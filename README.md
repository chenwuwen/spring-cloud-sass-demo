# Spring Cloud 示例应用


SpringCloud Version Greenwich.SR3 具体组件如下:

* 服务发现组件：consul
* 服务网关：gateway
* 服务熔断限流：alibaba sentinel
* 动态数据源组件：Dynamic-DataSource 
* 数据库操作组件：MybatisPlus
* 消息中间件组件：Kafka
* 服务监控组件：SpringBoot Admin


## 使用
首先运行sql文件夹中的sql脚本，数据库的名称应为 sql脚本的名称
其次provider-user/provider-biz 依赖 provider-base。故provider-base
应先于provider-user/provider-biz 运行


### 需要用到的中间件

[consul](https://releases.hashicorp.com/consul/)

[sentinel-dashboard](http://edas-public.oss-cn-hangzhou.aliyuncs.com/install_package/demo/sentinel-dashboard.jar)

[kafka](http://kafka.apache.org/downloads)

[kafka-manager](https://pan.baidu.com/s/1jIE3YL4?pwd=)

[zipkin-server](https://repo1.maven.org/maven2/io/zipkin/java/zipkin-server/)
