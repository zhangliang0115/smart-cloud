package com.smart.cloud.gateway;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhangliang
 * @version 1.0
 * @description 鉴权过滤器
 * @date 2019/5/30 10:40
 **/
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        if (token == null || token.isEmpty()) {
            ServerHttpResponse response = exchange.getResponse();

            // 错误信息
            JSONObject json=new JSONObject();
            json.put("code","501");
            json.put("massage","token 不能为空");
            try {

                // 返回错误信息
                DataBuffer buffer = response.bufferFactory().wrap(json.toString().getBytes());
                response.setStatusCode(HttpStatus.UNAUTHORIZED); //设置浏览器返回的回执码
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
