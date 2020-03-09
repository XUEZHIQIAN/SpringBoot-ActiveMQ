package com.miss.cloud.microservicesimplecomsumermovie.jms.sender;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.miss.cloud.microservicesimplecommon.entity.User;



@Service("movieMessageSender")
public class MovieMessageSender{

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void send(final User user) {
		
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage message = session.createObjectMessage(user);
				// 消息延时2分钟
				// message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 120 * 1000);  
				return message;
			}
		});
	}
	
}
