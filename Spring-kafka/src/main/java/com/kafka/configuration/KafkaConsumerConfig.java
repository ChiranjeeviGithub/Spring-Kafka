package com.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	
	@Bean
	public ConsumerFactory<String,String> consumerFactory(){
		
		Map<String,Object> comsumerConfigProperties = new HashMap<>();
		comsumerConfigProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		comsumerConfigProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id-1");
		comsumerConfigProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
		comsumerConfigProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
		return new DefaultKafkaConsumerFactory<>(comsumerConfigProperties);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> containerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory = new ConcurrentKafkaListenerContainerFactory<String,String>();
		kafkaFactory.setConsumerFactory(consumerFactory());
		return kafkaFactory;
		
	}
}
