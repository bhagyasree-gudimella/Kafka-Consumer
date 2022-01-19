package com.lavanya.gudimella.KafkaConsumer.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lavanya.gudimella.KafkaConsumer.Model.Employee;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "Kafka_Example", groupId = "group_id")
	public void consumeKafkaMessage(String message) {
		System.out.println(message);
	}
	
	
	@KafkaListener(topics = "Kafka_Example", groupId = "group_id", containerFactory = "empKafkaListenerFactory")
	public void empConsumeKafkaMessage(Employee employee) {
		System.out.println(employee.toString());
	}
}
