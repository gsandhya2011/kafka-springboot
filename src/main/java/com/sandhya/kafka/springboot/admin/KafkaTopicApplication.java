package com.sandhya.kafka.springboot.admin;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;


public class KafkaTopicApplication {
	 private final Properties properties;
	private Admin admin;
	private AdminClient adminClient;

	public KafkaTopicApplication(Properties properties) {
		this.properties = properties;
		this.admin = createAdmin();
		this.adminClient= createAdminClient();
	}
//	public void createTopic() throws Exception {
//		createTopic("sample",1,1);
//	}
	public AdminClient createAdminClient() {
		try {
			return AdminClient.create(properties);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public Admin createAdmin() {
		try {
		return Admin.create(properties);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void createTopic(String topicName,int partitions, short replicationFactor) throws Exception {
		
		
		NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
		CreateTopicsResult result = admin.createTopics(Collections.singleton(newTopic));
		// get the async result for the new topic creation
		KafkaFuture<Void> future = result.values().get(topicName);
		// call get() to block until topic creation has completed or failed
		future.get();
		
	}
	
	public Set<String> topicsList() throws InterruptedException, ExecutionException{
		
		Set<String> topicNames = admin.listTopics().names().get();
		admin.close();
		return topicNames;
	}
	
//	public void describeTopic(String topic) throws InterruptedException, ExecutionException, TimeoutException {
//		DescribeTopicsResult results = admin.describeTopics(Collections.singleton(topic));
//		results.all().get();
//		TopicDescription topicDescription = results.values().get(topic).get();
//		System.out.println(topicDescription);
//		KafkaFuture<Map<String,TopicDescription>> result=results.all();
//		TopicDescription topicdesc = result.get(10, TimeUnit.SECONDS).get(topic);
//		System.out.println(topicdesc.partitions().get(0).leader().id());
		
//		for(String topicName : topics)
//		System.out.println(result.get(topicName));
//			
		
//	}
	public void describeTopic(final String topicName) {
		  // Create admin client
		 try {
		    // Make async call to describe the topic.
		    final DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Collections.singleton(topicName));
		    
		    TopicDescription description = describeTopicsResult.values().get(topicName).get();
		    System.out.println(description.name());
		    System.out.println(description.partitions());
		  } catch (final InterruptedException | ExecutionException e) {
		    throw new RuntimeException(e.getMessage(), e);
		  }
		}
	
}
	 

