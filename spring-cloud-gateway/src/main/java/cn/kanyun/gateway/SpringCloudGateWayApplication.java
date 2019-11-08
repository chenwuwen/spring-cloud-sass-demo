package cn.kanyun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 启用服务注册发现,该注解是SpringCloud的原生注解
 * 而在Eureka中提供了@EnableEurekaClient注解,但只能用于和Eureka集成,虽然后面去掉了
 * @author Kanyun
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateWayApplication.class, args);
    }
}
