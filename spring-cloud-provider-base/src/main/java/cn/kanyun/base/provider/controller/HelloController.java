package cn.kanyun.base.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/base/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("message") String message) {
        return "i am base-provider your message is " + message;
    }
}
