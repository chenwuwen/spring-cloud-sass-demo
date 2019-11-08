package cn.kanyun.user.provider.controller;

import cn.kanyun.user.provider.service.SentinelTestService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Alibaba Sentinel 限流熔断
 *
 * @author Kanyun
 */
@Slf4j
@RestController
@RequestMapping("/user/sentinel")
public class SentinelTestController {

    @Autowired
    private SentinelTestService sentinelTestService;

    @GetMapping("/test")
    public String test() {
        return sentinelTestService.handler();
    }


}
