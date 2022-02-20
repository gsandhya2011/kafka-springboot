package com.sandhya.kafka.springboot.producer;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties
//@PropertySource("classpath:application.properties")
public class KafkaCSVProducer {

//	@Autowired
//	private Environment env;
	@Value("${spring.datasource.username}")
	String bootstraps;
	
	public void kafkaPublish() {
	Properties props = new Properties();
	
	
	System.out.println(bootstraps);
	//props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, env.getProperty("spring.kafka.bootstrap-servers") );
	
	}
	
}
