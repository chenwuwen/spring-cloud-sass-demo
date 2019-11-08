package cn.kanyun.user.provider.controller;

import cn.kanyun.domain.Business;
import cn.kanyun.user.provider.service.feign.BizServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/user/rpc/biz")
public class RemoteBizController {

    @Resource
    private BizServiceInterface bizServiceInterface;

    /**
     * 业务列表
     *
     * @return
     */
    @GetMapping("/getBizList")
    public List<Business> getBizList() {
        return bizServiceInterface.getBizList();
    }
}
