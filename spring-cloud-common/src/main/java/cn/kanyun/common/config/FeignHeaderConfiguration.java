package cn.kanyun.common.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign 配置
 * @author Kanyun
 */
@Slf4j
@Configuration
public class FeignHeaderConfiguration  {


    /**
     * 配置Feign日志Bean
     * 在Feign调用时会显示调用的信息
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 设置请求头bean
     * @return
     */
    @Bean
    public FeignHeaderRequestInterceptor feignHeaderRequestInterceptor() {
        return new FeignHeaderRequestInterceptor();
    }
}
