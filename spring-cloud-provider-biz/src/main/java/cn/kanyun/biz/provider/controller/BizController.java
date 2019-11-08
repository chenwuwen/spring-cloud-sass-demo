package cn.kanyun.biz.provider.controller;

import cn.kanyun.biz.provider.service.BizService;
import cn.kanyun.domain.Business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Kanyun
 */
@Slf4j
@RestController
@RequestMapping("/biz")
public class BizController {
    @Resource
    private BizService bizService;

    /**
     * 业务列表
     *
     * @return
     */
    @GetMapping("/getBizList")
    public List<Business> getBizList(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            log.info("/biz/getBizList 请求路径接收到请求,其header 为 [{}:{}]", header, request.getHeader(header));
        }
        return bizService.queryAll();
    }
}
