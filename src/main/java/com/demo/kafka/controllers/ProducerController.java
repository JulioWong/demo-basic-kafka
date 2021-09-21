package com.demo.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.models.AuditDetails;
import com.demo.kafka.service.ProduceKafkaService;

@RestController
@RequestMapping("/api")
public class ProducerController {
	
	@Autowired
	ProduceKafkaService produceKafkaService;

	@PostMapping("/sendMessage")
	public ResponseEntity<AuditDetails> sendMessage(@RequestBody AuditDetails aud) {
		return new ResponseEntity<AuditDetails>(produceKafkaService.sendMessage(aud), HttpStatus.CREATED);
	}
}
