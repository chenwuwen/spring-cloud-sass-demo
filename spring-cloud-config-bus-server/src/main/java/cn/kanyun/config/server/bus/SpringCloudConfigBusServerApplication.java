package cn.kanyun.config.server.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCLoud Config客户端
 * 用来测试服务端
 *
 * 由于使用kafka 使用需要下载kafka ，需要注意的是
 * 新版的Kafka已经自带了zookeeper，所以不需要单独安装zookeeper
 * 启动kafka时,先启动zookeeper ，windows下命令：
 * zookeeper-server-start.bat zookeeper.properties
 * kafka-server-start.bat server.properties
 * 注意配置文件的位置，按照自身情况设定
 *
 * @author Kanyun
 * @SpringCloudApplication 注解包含了 @SpringBootApplication @EnableDiscoveryClient注解
 * @EnableConfigServer 注解激活配置中心服务。配置中心可以单独做服务，也可以嵌入到其它服务中。推荐用单独做服务方式使用配置中心
 */
@SpringCloudApplication
@EnableConfigServer
public class SpringCloudConfigBusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigBusServerApplication.class, args);
    }
}
