package cn.kanyun.gateway;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限验证
 * GrateWay包含两种过滤器：GlobalFilter , GatewayFilter
 * GlobalFilter 是全局起作用的。
 * GatewayFilter 是针对部分路由起作用
 *
 * @author Kanyun
 */
//@Component
public class AuthFilter implements GlobalFilter, Ordered {

    /**
     * 返回Mono对象，说明使用的是WebFlux
     * 如果是使用SpringMvc 那么应该是返回ModelAndView
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if ("token".equals(token)) {
//            通过验证
            return chain.filter(exchange);
        }
        if (exchange.getRequest().getPath().toString().contains("login")) {
//            判断请求路径是否是登录路径
            return chain.filter(exchange);
        }

        ServerHttpResponse response = exchange.getResponse();
        Map<String, Object> data = new HashMap(2);

        data.put("code", 401);
        data.put("message", "非法请求");
        byte[] bytes = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bytes);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    /**
     * Filter执行顺序,数字越小越优先执行
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
