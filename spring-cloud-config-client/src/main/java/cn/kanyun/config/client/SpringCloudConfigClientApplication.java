package cn.kanyun.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * SpringCloud Config客户端
 * 用来测试配置中心服务端
 *
 * @author Kanyun
 * @SpringCloudApplication 注解包含了 @SpringBootApplication @EnableDiscoveryClient注解
 */
@SpringCloudApplication
public class SpringCloudConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
