package com.sandhya.kafka.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandhya.kafka.springboot.producer.TopicProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/kafka")
public class KafkaController {
	private final TopicProducer topicProducer;
	
	@GetMapping(value = "/send")
	public void send() {
		topicProducer.send("Hello, this is my first message");
	}
}
