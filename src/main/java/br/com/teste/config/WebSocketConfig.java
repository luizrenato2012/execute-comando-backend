package br.com.teste.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

// getting Started with Spring WebScoket - https://spring.io/guides/gs/messaging-stomp-websocket/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// broker in memoria q leva mensagem de volta aos client´s 
		registry.enableSimpleBroker("/topic");
		//acrescenta prefixo no endereço do broker dos metodos anotados com @MessageMapping ex: app/executa
		registry.setApplicationDestinationPrefixes("/app"); 
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/webserver")
			.setAllowedOrigins("*")
			.withSockJS(); // usado para conexao pelo client
	}
	
	

}
