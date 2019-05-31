package com.smart.cloud.gateway;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author zhangliang
 * @version 1.0
 * @description 网关启动类
 * @date 2019/5/20 12:58
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class GatewayApplication {

    @Value("${smart.cloud.name:}")
    private String name;


    @Bean
    @RefreshScope
    public Map<String, String> getName() {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class)
                .run(args);
    }

    @Bean
    public BlockRequestHandler blockRequestHandler() {
        return (exchange, t) ->{
            JSONObject json=new JSONObject();
            json.put("code", HttpStatus.TOO_MANY_REQUESTS.value());
            json.put("massage",HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());
             return   ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(fromObject(json));
        };

    }

    //    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
//                .route("path_route", r -> r.path("/get","/anything","/ip")
//                        .uri("http://httpbin.org:80"))
                .route("host_route", r -> r.host("*.myhost.org")
                        .uri("http://httpbin.org"))
                .route("rewrite_route", r -> r.host("*.rewrite.org")
                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/anything?name=${segment}"))
                        .uri("http://httpbin.org"))
                .route("websocket_route", r -> r.path("/echo")
                        .uri("ws://localhost:9000"))


//                .route("hystrix_route", r -> r.host("*.hystrix.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
//                        .uri("http://httpbin.org"))
//                .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
//                        .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
//                        .uri("http://httpbin.org"))
//                .route("limit_route", r -> r
//                        .host("*.limited.org").and().path("/anything/**")
//                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//                        .uri("http://httpbin.org"))
                .build();
    }


}
