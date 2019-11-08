package cn.kanyun.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @EnableFeignClients标注用于修饰Spring Boot应用的入口类，以通知Spring Boot启动应用时，
 * 扫描应用中声明的Feign客户端可访问的Web服务
 * @author Kanyun
 */
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan({"cn.kanyun.user","cn.kanyun.common"})
@SpringBootApplication
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }
}
