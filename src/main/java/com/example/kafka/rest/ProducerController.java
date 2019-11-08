package com.example.kafka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Value("${spring.kafka.template.default-topic}")
	String topic;

	@Autowired
	KafkaTemplate<Long, String> template;

	@GetMapping("store/{name}")
	public void produce(@PathVariable("name") String message) {
		System.out.println("sending message: " + message);
		template.send(topic, message);
	}
}
