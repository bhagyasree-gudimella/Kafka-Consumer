package com.lavanya.gudimella.KafkaConsumer.Configuration;

import java.util.HashMap; 
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.lavanya.gudimella.KafkaConsumer.Model.Employee;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Bean
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, Object>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String , String> listenerFactory = new ConcurrentKafkaListenerContainerFactory<String , String>();
		listenerFactory.setConsumerFactory(consumerFactory());
		return listenerFactory;
	}
	
	@Bean
	public ConsumerFactory<String, Employee> empConsumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, Employee>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Employee> empKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String , Employee> empListenerFactory = new ConcurrentKafkaListenerContainerFactory<String , Employee>();
		empListenerFactory.setConsumerFactory(empConsumerFactory());
		return empListenerFactory;
	}
}
