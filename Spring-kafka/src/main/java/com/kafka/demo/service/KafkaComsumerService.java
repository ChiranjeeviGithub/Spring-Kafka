package com.kafka.demo.service;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaComsumerService {
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	@KafkaListener(topics="java_in_use_topic")
	public void receive(ConsumerRecord<?,?> consumerRecord){
		
		System.out.println("Hello world  "+ consumerRecord.toString());
	}
	

}
