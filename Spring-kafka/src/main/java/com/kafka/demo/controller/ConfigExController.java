package com.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigExController {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka_topic}")
	String topic;
	
	@RequestMapping("/configProducer")
	public String producer(){
		kafkaTemplate.send(topic,"Chiranjeevi 1");
		return " Message has sent sucessfully";
	}
	
	@KafkaListener(topics="${kafka_topic}",groupId="group-id-1")
	public void consumer(String message){
		System.out.println("Consumer message is "+message);
	}
}
