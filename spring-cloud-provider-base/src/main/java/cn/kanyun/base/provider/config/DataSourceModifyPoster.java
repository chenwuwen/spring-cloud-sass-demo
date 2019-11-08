package cn.kanyun.base.provider.config;

import cn.kanyun.common.stream.DataSourceModifyEnum;
import cn.kanyun.common.stream.DataSourceModifySource;
import cn.kanyun.domain.Tenant;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 向消息队列中发送数据源的改变
 * 这里使用Guava的EventBus
 *
 * @author Kanyun
 * @EnableBinding(Source.class) 这个注解给我们绑定消息通道的，Source是Stream给我们提供的，
 * 可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的
 * 当然也可以自定义
 */
@Slf4j
@Component
@EnableBinding(DataSourceModifySource.class)
public class DataSourceModifyPoster {

    @Autowired
    private DataSourceModifySource dataSourceModifySource;

    @Subscribe
    public void dataSourceModify(Tenant tenant) {
        log.debug("接收到数据源变化事件");
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPollName(tenant.getDomain());
        dataSourceProperty.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceProperty.setPassword(tenant.getDbPass());
        dataSourceProperty.setUrl(tenant.getDbUrl());
        dataSourceProperty.setUsername(tenant.getDbUser());
        log.info("数据源发生变化,base-provider使用SpringCloud Stream发送消息");
        Gson gson = new Gson();
        String dataSourcePropertyJson = gson.toJson(dataSourceProperty);

//        构造消息
        MessageBuilder messageBuilder = MessageBuilder.withPayload(dataSourcePropertyJson);
//        设置Message的header,可以通过设置头信息,是消息接受者,知道数据源的改变时新增还是删除,还是修改
        if (dataSourceProperty.getUrl() == null || dataSourceProperty.getUsername() == null || dataSourceProperty.getPassword() == null) {
            messageBuilder.setHeader(DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE, DataSourceModifyEnum.DELETE);
        } else {
            messageBuilder.setHeader(DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE, DataSourceModifyEnum.UPDATE);
        }
//        利用SpringCloud stream向消息队列发送消息
        dataSourceModifySource.output().send(messageBuilder.build());
    }
}
