package cn.kanyun.user.provider.service.feign.fallback;

import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import cn.kanyun.user.provider.service.feign.BaseServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Kanyun
 */
@Component
@Slf4j
public class BaseServiceInterfaceFallBack implements BaseServiceInterface {

    @Override
    public List<DataSourceProperty> getDataSourceProperty() {
        log.error("从base-provider微服务取数据源属性集合报错");
        return null;
    }

    @Override
    public String remoteHello(String message) {
        return "调用base-provider hello方法出错";
    }
}
