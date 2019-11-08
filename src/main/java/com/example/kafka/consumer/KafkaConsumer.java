package com.example.kafka.consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "store", groupId = "store-group-1")
	public void consume(String message) {
		System.out.println("Received: " + message);
	}

}
