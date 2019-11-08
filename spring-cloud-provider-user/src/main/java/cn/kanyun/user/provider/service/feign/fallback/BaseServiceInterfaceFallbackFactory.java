package cn.kanyun.user.provider.service.feign.fallback;


import cn.kanyun.dynamic.datasource.springboot.autoconfigure.DataSourceProperty;
import cn.kanyun.user.provider.service.feign.BaseServiceInterface;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * fallback不能显示feign远程调用的错误信息
 * 定义FallbackFactory,让其实现FallbackFactory接口
 * 并通过调用create函数，其中throwable 会记录捕获的所有异常，我们通过getMessage可得到我们的信息
 *
 * @author Kanyun
 */
@Component
@Slf4j
public class BaseServiceInterfaceFallbackFactory implements FallbackFactory<BaseServiceInterface> {
    @Override
    public BaseServiceInterface create(Throwable cause) {
        log.error("BaseServiceInterface访问远程服务报错:{}", cause);
        return new BaseServiceInterface() {
            @Override
            public List<DataSourceProperty> getDataSourceProperty() {
                return null;
            }

            @Override
            public String remoteHello(String message) {
                return "BaseServiceFallbackFactory Error";
            }
        };
    }
}
