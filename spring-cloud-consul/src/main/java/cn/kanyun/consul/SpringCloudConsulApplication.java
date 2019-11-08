package cn.kanyun.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务发现组件
 * consul agent -dev -http-port 8500 -client 0.0.0.0 启动Consul
 * -dev:是开发服务器模式,不能用于生产环境，因为该模式下不会持久化任何状态，该启动模式仅仅是为了快速便捷的启动单节点consul
 * @EnableDiscoveryClient 注解表示支持服务发现
 * @author Kanyun
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulApplication.class, args);
    }
}
