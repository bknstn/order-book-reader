package by.bknstn.practise.crypto.orderbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@EnableWebSocket
@Configuration
public class WebConfig extends WebSocketMessageBrokerConfigurationSupport {
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setMessageSizeLimit(32768);
        registry.setSendBufferSizeLimit(32768);
        super.configureWebSocketTransport(registry);
    }

    @Override
    protected void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }
}
