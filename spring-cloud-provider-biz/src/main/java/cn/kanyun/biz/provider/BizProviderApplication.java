package cn.kanyun.biz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot使用多数据源：
 * 首先要将spring boot自带的DataSourceAutoConfiguration禁掉，因为它会读取application.properties文件的spring.datasource.*属性并自动配置单数据源。在@SpringBootApplication注解中添加exclude属性即可
 * @author Kanyun
 */
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan({"cn.kanyun.biz","cn.kanyun.common"})
@SpringBootApplication
public class BizProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizProviderApplication.class, args);
    }
}
