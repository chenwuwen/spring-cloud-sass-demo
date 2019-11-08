package cn.kanyun.base.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 基础服务
 * 这里配置了@ComponentScan是因为,该注解默认只扫描启动类所在的包及其子包
 * 由于有一些配置是放到了common模块下,而本模块又依赖了common模块,因此如果
 * 本模块需要使用common模块定义的配置类,那么应该扫描common模块的配置类
 * @author Kanyun
 */
@EnableFeignClients
@ComponentScan({"cn.kanyun.base","cn.kanyun.common"})
@SpringCloudApplication
public class BaseProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseProviderApplication.class, args);
    }
}
