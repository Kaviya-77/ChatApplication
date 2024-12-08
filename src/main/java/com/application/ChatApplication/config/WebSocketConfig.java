package com.application.ChatApplication.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat") //our localhost:8080/chats
		.setAllowedOrigins("http://localhost:8080") //security feature to prevent 
		//any unauthorized broadcast or message into our application
		//entertain request from the url only
		.withSockJS(); //add compatibility to the clients who don't support web sockets
		//makes the app accsible to the more users
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
	    //set a simple message broker
		//this line for telling the server when to expect the message 
		//server will process the message, with particular prefix
		
		registry.enableSimpleBroker("/topic");
		// who ever subscribe to the broadcast(/topic) they will get the broadcast channel messages 
		//whatever message are updating
		registry.setApplicationDestinationPrefixes("/app");
		//telling server any message with this prefix process it
		
	}


	
	

}
