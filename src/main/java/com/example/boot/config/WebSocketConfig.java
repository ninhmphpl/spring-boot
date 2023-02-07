package com.example.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //>> được dùng để bật tính năng WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //>> import nó
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //>> địa chỉ đich mà client sẽ gửi >> localhost:8080/socket
        registry.addEndpoint("/socket")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/message");
    }
}
