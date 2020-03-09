package com.miss.cloud.microservicesimplecomsumermovie.jms.listener;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.miss.cloud.microservicesimplecomsumermovie.entity.User;

public class SendMessageListener implements MessageListener{
	
	private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	// user.address=http://localhost:8443/miss/query/
	@Value("${user.address}")
	private String host;

	@Override
	public void onMessage(Message msg) {
		
		try {
			ObjectMessage message = (ObjectMessage) msg;
			// TODO 队列是正常的，但是消息内容不能转换
			Serializable object = message.getObject();
			
			User user = (User) object;
			
			Long id = user.getId();
			
			user = restTemplate.getForObject(host + id, User.class);
			String username = user.getUsername();
			int age = user.getAge();
			log.info("reviceMessage username={}, age={}", username, age);
			
		} catch (JMSException e) {
			log.error("jms message is exception.", e);
		}
	}

}
