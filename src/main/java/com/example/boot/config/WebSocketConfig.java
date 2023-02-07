package com.example.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //>> được dùng để bật tính năng WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //>> import nó
    /**
     * Trong phương thức đầu tiên, chúng ta đăng ký một websocket endpoint mà các máy khách sẽ sử dụng để kết nối với máy chủ websocket của chúng ta.
     * Lưu ý việc sử dụng withSockJS() với endpoint configuration. SockJS được sử dụng để bật tùy chọn dự phòng cho các trình duyệt không hỗ trợ websocket.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    /**
     * định nghĩa rằng các thông điệp có đích bắt đầu bằng “/topic” nên được định tuyến tới nhà môi giới tin nhắn.
     * Nhà môi giới tin nhắn sẽ phát các tin nhắn đến tất cả các khách hàng được kết nối đã đăng ký một chủ đề cụ thể.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }

}
