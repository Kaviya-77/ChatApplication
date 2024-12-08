package com.application.ChatApplication.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.ChatApplication.model.ChatMessage;

@Controller
public class ChatController {
	//handle all the incoming messages sent from the front end and add (broadcast) 
	//it to clients
	
	
	// when any one send the message to /app/sendMessage(endpoint) 
	// it get broadcasted to other connected clients onto this particular /topic

	@MessageMapping("/sendMessage")  
	//maps the web socket messages to the 
	//destination(/sendMessage)
	//whenever clients send message to the end point
	
	@SendTo("/topic/messages")  //return of this method(sendMessage) sendTo 
	//particular chat room(/topic/messages)(like all the subscribers of the 
	//particular room (here topic)
	public ChatMessage sendMessage(ChatMessage message) {
		System.out.println("received message  "+ message);
		 return message;
	}
	
	
	//who ever visiting the root url we will return the thymeleaf template
	//anyone visit the localhost:8080/chat it will the particular thymeleaf content
	@GetMapping("index")
	public String chat() {
		return "index"; /// name of the thymeleaf template
	}
	

}
