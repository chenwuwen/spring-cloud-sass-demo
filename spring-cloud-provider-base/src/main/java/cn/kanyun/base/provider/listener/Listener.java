package cn.kanyun.base.provider.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author Kanyun
 */
public class Listener {

    /**
     * @param event 该参数 必须是ApplicationEvent的子类
     * @EventListener spring监听器注解 方法中的参数是要监听的事件
     */
    @EventListener
    public void exec(ContextRefreshedEvent event) {
//        判断spring容器是否加载完成
        if (event.getApplicationContext().getParent() == null) {
        }
    }
}
