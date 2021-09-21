package com.demo.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerKafkaService {
	
	
	private static final Logger log = LoggerFactory.getLogger(ListenerKafkaService.class);


	@KafkaListener(topics = "demo-kafka-topic", groupId = "foo")
	public void listen(String message) {
		log.info("Message receive {}", message);
	}

}
