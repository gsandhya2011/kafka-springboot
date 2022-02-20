package com.sandhya.kafka.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import com.sandhya.kafka.springboot.admin.KafkaTopicApplication;
import com.sandhya.kafka.springboot.producer.KafkaCSVProducer;

@EnableKafka
@SpringBootApplication
public class KafkaSpringbootApplication {

	public static void main(String[] args) throws Exception {
//		Properties props = new Properties();
//        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
//        
		SpringApplication.run(KafkaSpringbootApplication.class, args);
//		KafkaTopicApplication kafkaTopic = new KafkaTopicApplication(props);
//
//		Set<String> topics = kafkaTopic.topicsList();
//		if(topics.isEmpty()) {
//			System.out.println("No topics found");
//		}
//		else {
//		for(String s:topics) {
//			System.out.println(s);
//		}
//		}
//		for(String topic: topics)
//			kafkaTopic.describeTopic(topic);
		
//		KafkaCSVProducer  producer= new KafkaCSVProducer();
//		producer.kafkaPublish();
	}

}
