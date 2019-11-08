package cn.kanyun.common.config;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Guava EventBus配置
 * 虽然EventBus可以直接通过new来使用
 * 但是由于使用了spring,那么就将EventBus的生命周期交给spring IOC去管理吧
 * @author Kanyun
 */
@Configuration
public class EventBusConfiguration {

    /**
     * 定义事件总线bean
     * @return
     */
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
