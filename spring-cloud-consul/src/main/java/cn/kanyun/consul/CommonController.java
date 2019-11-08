package cn.kanyun.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/consul")
public class CommonController {

    /**
     * 注入负载均衡bean
     */
    @Autowired
    private LoadBalancerClient loadBalancer;

    /**
     * 注入服务发现客户端
     */
    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * 获取所有服务
     */
    @GetMapping("/getServices")
    public Object services() {
        return discoveryClient.getServices();
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     * 返回服务Uri
     */
    @GetMapping("/discover")
    public Object discover(@RequestParam("serviceId") String serviceId) {
        return loadBalancer.choose(serviceId).getUri().toString();
    }


}
