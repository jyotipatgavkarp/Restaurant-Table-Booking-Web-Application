package com.hotelproject.tablebooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TablebookingApplication {
//	@Autowired
//	private EmailSender service;

	public static void main(String[] args) {
		SpringApplication.run(TablebookingApplication.class, args);
	}
		
//		@EventListener(ApplicationReadyEvent.class)
//		public void triggerMail()
//		{
//			service.mysendmail("jyotipatgavkar05@gmail.com" , "this is the email body", "this is email subject");
//			
//		}
	

}
