package cn.kanyun.user.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Kanyun
 */
@Slf4j
@Service
public class SentinelTestService {

    /**
     * 虽然通过sentinel-dashboard 可以对所有Spring MVC接口进行限流控制
     * 然而，在实际应用过程中，我们可能需要限流的层面不仅限于接口。可能对于某个方法的调用限流，
     * 对于某个外部资源的调用限流等都希望做到控制。
     * 这个时候我们就不得不手工定义需要限流的资源点，并配置相关的限流策略等内容了
     * 那么使用@SentinelResource注解可以灵活的定义控制资源以及如何配置控制策略
     * 标注了@SentinelResource注解的资源,就会在sentinel-dashboard 中显示出来(需要设置bean {@Link SentinelConfiguration} )
     * 需要注意的是被@SentinelResource标注的方法,不能与调用方在同一个类中,否则不会生效,原因来自spring aop
     *
     * @return
     */
    @SentinelResource(value = "SentinelTestService.handler()", blockHandler = "blockHandlerMethod")
    public String handler() {
        return "正常调用";
    }

    /**
     * 限流的异常处理
     * 默认情况下，Sentinel对控制资源的限流处理是直接抛出异常
     * 限流与阻塞处理
     * 通过@SentinelResource注解的blockHandler属性制定具体的处理函数
     * 实现处理函数，该函数的传参必须与资源点的传参一样，并且最后加上BlockException异常参数；
     * 同时，返回类型也必须一样
     *
     * @param ex
     */
    public String blockHandlerMethod(BlockException ex) {
        log.error("blockHandlerMethod：{}", ex);
        return "请求过于频繁";
    }
}
