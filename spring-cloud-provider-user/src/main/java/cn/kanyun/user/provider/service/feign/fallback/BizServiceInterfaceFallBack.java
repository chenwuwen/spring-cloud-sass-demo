package cn.kanyun.user.provider.service.feign.fallback;

import cn.kanyun.domain.Business;
import cn.kanyun.user.provider.service.feign.BizServiceInterface;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * BizServiceInterface对应的服务容错
 *
 * @author Kanyun
 */
@Component
public class BizServiceInterfaceFallBack implements BizServiceInterface {
    @Override
    public String remoteHello(String message) {
        return "服务繁忙,稍后重试：" + message;
    }

    @Override
    public List<Business> getBizList() {
        return Collections.emptyList();
    }
}
