package cn.kanyun.user.provider.config;

import cn.kanyun.common.stream.DataSourceModifyEnum;
import cn.kanyun.common.stream.DataSourceModifySource;
import cn.kanyun.dynamic.datasource.DynamicDataSourceCreator;
import cn.kanyun.dynamic.datasource.DynamicRoutingDataSource;
import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import javax.sql.DataSource;

/**
 * 数据源改变 消息接收者
 * 使用消息队列
 *
 * @author Kanyun
 * @EnableBinding(Sink.class) 消息接受端，
 * stream给我们提供了Sink,Sink源码里面是绑定input的，要跟我们配置文件的input关联的，当然也可以自定义
 */
@Slf4j
@EnableBinding(DataSourceModifySource.class)
public class DataSourceModifyReceiver {

    /**
     * 注入动态数据源 路由
     */
    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    /**
     * 注入动态数据源 创建器
     */
    @Autowired
    private DynamicDataSourceCreator dynamicDataSourceCreator;

    /**
     * 接收消息队列中数据
     *
     * @param payload
     * @StreamListener，主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器， 注解中的属性值对应了监听的消息通道名
     * @StreamListener(管道id，如Sink.INPUT)。管道id是在接收器中定义的
     */
    @StreamListener(DataSourceModifySource.INPUT_PIPE_NAME)
    public void receive(Message<String> payload) {
        Gson gson = new Gson();
        String dataSourcePropertyJson = payload.getPayload();
        log.info("user-provider 从 SpringCloud Stream 接收到DataSourceModifySource的消息：[{}]", dataSourcePropertyJson);
        DataSourceProperty dataSourceProperty = gson.fromJson(dataSourcePropertyJson, DataSourceProperty.class);
        MessageHeaders messageHeaders = payload.getHeaders();
        if (messageHeaders.containsKey(DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE)) {
//        获取Message的Header,如果包含 DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE 的header,那么判断该header的值,从而判断是更改数据源还是删除数据源
            if (messageHeaders.get(DataSourceModifySource.MESSAGE_HEADER_MODIFY_TYPE) == DataSourceModifyEnum.DELETE) {
                dynamicRoutingDataSource.removeDataSource(dataSourceProperty.getPollName());
            } else {
//        根据DataSourceProperty数据源属性 使用 数据源创建器创建数据源
                DataSource dataSource = dynamicDataSourceCreator.createBasicDataSource(dataSourceProperty);
//        将新创建出来的数据源,添加到本应用的动态数据源集合中
                dynamicRoutingDataSource.addDataSource(dataSourceProperty.getPollName(), dataSource);
            }
        }
    }
}
