package com.sandhya.kafka.springboot.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

	@Value("${topic.name.consumer}")
	private String topicName;
	
	@KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
	public void consume(ConsumerRecord<String, String> payload) {
		log.info("Key: {}", payload.key());
		log.info("Header:{}", payload.headers());
		log.info("Partition: {}", payload.partition());
		log.info("Order: {}", payload.value());
		
	}
}
