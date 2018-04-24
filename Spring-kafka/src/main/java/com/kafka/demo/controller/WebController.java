package com.kafka.demo.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.service.KafkaComsumerService;
import com.kafka.demo.service.KafkaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class WebController {
	
	@Autowired
	KafkaProducerService kafkaSenderService;
	
	@Autowired
	KafkaComsumerService kafkaComsumerService;

	@GetMapping(value ="/producer")
	public String producer(@RequestParam("message") String message ){
		
		kafkaSenderService.send(message);
		return "Message --->"+message+" has sent kafka topic";
	}
	@KafkaListener(topics="${kafka.topic}")
	public void receive(ConsumerRecord<?,?> consumerRecord){
		System.out.println("Consumer Record : " + consumerRecord.toString());
	}
	
	
	// This code for Batch Listener  
	/*public static final int COUNT = 20;
	private CountDownLatch latch = new CountDownLatch(COUNT);
	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(id = "batch-listener", topics = "kafka-topic-1")
	public void receive(List<String> data, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
			@Header(KafkaHeaders.OFFSET) List<Long> offsets) {

		for (int i = 0; i < data.size(); i++) {
			System.out.println("received message='{}' with partition-offset='{}'," + data.get(i) + ","
					+ partitions.get(i) + "-" + offsets.get(i));
			latch.countDown();
		}
		System.out.println("end of batch receive");
	}*/
	
}
