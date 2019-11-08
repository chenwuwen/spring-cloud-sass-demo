package cn.kanyun.biz.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/biz/hello")
public class HelloController {

    /**
     * 测试 Feign
     *
     * @param message
     * @return
     */
    @GetMapping("/hello")
    public String hello(@RequestParam("message") String message, HttpServletRequest request) {
//        getLocalPort获取的是应用服务器的端口，即该应用的实际端口，无论请求经过了多少代理，转发，getLocalPort只取最后的端口，也就是应用的端口。
//        getServerPort获取的是URL请求的端口，比如你的请求时127.0.0.1:8080，应用服务器的端口是80，那么getServerPort得到的端口是8080。而getLocalPort得到的是80
        int port = request.getLocalPort();
        String ip = request.getLocalAddr();
        String domain = request.getHeader("domain");
        return "Biz-Provider -> " + message + "  =>>" + "from: " + ip + ":" + port + " Header -> domain：" + domain;
    }
}
