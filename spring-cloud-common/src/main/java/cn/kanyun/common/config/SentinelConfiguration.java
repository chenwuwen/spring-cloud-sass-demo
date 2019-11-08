package cn.kanyun.common.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kanyun
 */
@Configuration
public class SentinelConfiguration {

    /**
     * 注解支持的配置Bean
     * 只有配置了该bean   @SentinelResource注解才会生效
     * @return
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
