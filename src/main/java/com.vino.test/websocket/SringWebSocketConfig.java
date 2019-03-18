package com.vino.test.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ClassName: SringWebSocketConfig
 * @Description: WebSocket的核心配置处理器（配置websocket入口，允许访问的域、注册Handler、SockJs支持和拦截器。）
 * @author: wenjie.fei
 * @date: 2019/1/5 10:37
 * @version: V1.0
 */
@Configuration
@EnableWebSocket
public class SringWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new SpringWebSocketHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/ws").addInterceptors(new SpringWebSocketHandShake());
        registry.addHandler(webSocketHandler(), "/ws/sockjs").addInterceptors(new SpringWebSocketHandShake()).withSockJS();
    }

}
