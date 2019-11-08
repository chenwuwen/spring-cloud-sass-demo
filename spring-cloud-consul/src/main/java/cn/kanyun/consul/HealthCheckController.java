package cn.kanyun.consul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 * 这个并不需要自己去写,如果依赖了spring-boot-starter-actuator
 * 那么就会健康检查的接口了,其他组件默认也是从spring-boot-starter-actuator
 * 的接口来判断健康状态
 * @author Kanyun
 */
@RestController
public class HealthCheckController {

    /**
     * Consul 会定时请求该接口,用以判断服务 运行状态是否正常
     * @return
     */
    @GetMapping("/health")
    public String health() {
        return "I am running";
    }
}
