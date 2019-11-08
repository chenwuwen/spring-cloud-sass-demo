package cn.kanyun.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试SpringCloud 配置仓库是能够获取配置信息
 *
 * @author Kanyun
 * @RefreshScope 注解是配置刷新的注解, 如果配置中心中的信息发生变化的话，客户端的信息是不会跟着变化的
 * 需要增加一个监控模块：spring-boot-starter-actuator 在pom.xml/build.gradle中增加依赖
 * 并且在Controller中增加@RefreshScope注解
 * actuator给我们提供了一个/actuator/bus-refresh接口，修改完git仓库信息之后，向这个接口发送一个POST信息，就会更新配置信息了。
 * 如果代码中需要动态刷新配置，在需要的类上加上该注解就行 @RefreshScope作用的类，不能是final类，否则启动时会报错
 */
@RestController
@RefreshScope
@RequestMapping("/config/client")
public class SpringCloudConfigClientController {

    @Value("${name}")
    private String name;

    @Value("${sex}")
    private String sex;

    @Value("${age}")
    private int age;

    @GetMapping("/")
    public String testSpringCloudServer() {
        System.out.println(name + ":" + sex + ":" + age);
        return name + ":" + sex + ":" + age;
    }
}
