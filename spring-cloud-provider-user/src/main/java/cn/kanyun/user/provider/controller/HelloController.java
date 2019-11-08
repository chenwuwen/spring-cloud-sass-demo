package cn.kanyun.user.provider.controller;

import cn.kanyun.user.provider.service.feign.BaseServiceInterface;
import cn.kanyun.user.provider.service.feign.BizServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/user/hello")
public class HelloController {
    @Resource
    private BizServiceInterface bizServiceInterface;
    @Resource
    private BaseServiceInterface baseServiceInterface;

    /**
     * 通过Feign 调用BizProvider 的hello方法
     *
     * @param message
     * @return
     */
    @GetMapping("/bizRemoteHello")
    public String bizRemoteHello(@RequestParam("message") String message) {
        return bizServiceInterface.remoteHello(message);
    }

    /**
     * 通过Feign 调用BizProvider 的hello方法
     *
     * @param message
     * @return
     */
    @GetMapping("/baseRemoteHello")
    public String baseRemoteHello(@RequestParam("message") String message) {
        return baseServiceInterface.remoteHello(message);
    }

    /**
     * 本地的hello方法
     *
     * @param message
     * @return
     */
    @GetMapping("/localHello")
    public String localHello(@RequestParam("message") String message) {
        return "user-provider UserController hello：" + message;
    }
}
