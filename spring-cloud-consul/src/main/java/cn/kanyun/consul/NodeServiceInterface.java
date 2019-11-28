package cn.kanyun.consul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用NodeJs服务 Feign 接口
 * @author Kanyun
 */
@FeignClient(value = "NODE-SERVICE",fallback = NodeServiceInterfaceFallback.class)
public interface NodeServiceInterface {

    /**
     * 访问NODE-SERVICE服务下的/search/users/接口
     * @return
     */
    @GetMapping("/search/users/")
    String searchUsers();
}
