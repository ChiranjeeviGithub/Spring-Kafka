package com.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	String kafkaTopic= "java_in_use_topic";
	
	public void send(String message){
		
		System.out.println("Message is "+ message);
		kafkaTemplate.send(kafkaTopic, message);
	}

}
