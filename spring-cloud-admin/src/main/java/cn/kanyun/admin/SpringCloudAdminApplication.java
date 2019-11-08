package cn.kanyun.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * SpringBoot Admin 监控配置 需要添加@EnableAdminServer注解
 * 需要注意的而是springboot admin是需要数据库的,可以使用嵌入式数据库,只需要添加相应依赖就可以了(如H2)
 * 如果使用诸如Mysql之类的数据库,那么则需要在application.yml中配置对应的数据源
 * 同时由于依赖了数据库,那么也要依赖jdbc,或者mybatis 否则无法构建datasource
 * @author Kanyun
 */
@EnableAdminServer
@SpringCloudApplication
public class SpringCloudAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAdminApplication.class, args);
    }
}
