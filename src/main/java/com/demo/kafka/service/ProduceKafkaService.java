package com.demo.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.kafka.models.AuditDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProduceKafkaService {
	
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	public AuditDetails sendMessage(AuditDetails aud) {
		AuditDetails auditDetails = aud;
		
		try {
			kafkaTemplate.send("demo-kafka-topic", objectMapper.writeValueAsString(auditDetails));
		} catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Error parsing message %s", "test"));
		}
		
		
		return auditDetails;
	}
	
	
}
