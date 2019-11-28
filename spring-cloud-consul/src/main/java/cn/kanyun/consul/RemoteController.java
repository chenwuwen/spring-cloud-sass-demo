package cn.kanyun.consul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kanyun
 */
@RestController
@RequestMapping("/rpc")
public class RemoteController {

    @Resource
    private NodeServiceInterface nodeServiceInterface;

    /**
     * @return
     */
    @GetMapping("/searchUsers")
    public String searchUsers() {
        return nodeServiceInterface.searchUsers();
    }

}
