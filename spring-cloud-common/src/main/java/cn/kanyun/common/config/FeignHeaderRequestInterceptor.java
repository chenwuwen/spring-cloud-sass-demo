package cn.kanyun.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign请求头配置
 * 转发请求头
 * 即：浏览器发出了一个请求 通过网关 到达 微服务A
 * 而微服务A 又通过 Feign 调用了微服务B
 * 那么浏览器请求微服务A所携带的headers 会原封不动的由微服务A 转发给 微服务B
 *
 * @author Kanyun
 */
@Slf4j
public class FeignHeaderRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
//        当项目刚启动时,模块通过Feign主动发起请求到其他模块,此时attributes可能为null导出抛出异常,如果没有此类情况,可以不判断
//        在FeignClient中,也可以通过@Header注解,来设置服务间RPC调用的header
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    template.header(name, values);

                }
                log.info("FeignHeaderConfiguration feign interceptor header:{}", template);
            }
        }
    }
}
