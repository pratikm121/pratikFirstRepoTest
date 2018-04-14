package com.test;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.nio.cs.ext.ISCII91;

/**
 * Message-Driven Bean implementation class for: TestMdb
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName = "destinationJndiName",propertyValue = "jms/localqtwo"),
				@ActivationConfigProperty(propertyName = "connectionFactoryJndiName",propertyValue = "BRESQueueConnectionFactory")})

public class TestMdb implements MessageListener {
	private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(TestMdb.class);
    @Resource 
	long retryInterval = 3000;

    public TestMdb() {
    }
	
	public void onMessage(Message message) {
		System.out.println("bean called");
		/*if (message instanceof TextMessage){
			TextMessage msg = (TextMessage) message;
            try {
				log.info("Message is : " + msg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}*/
	}
		

}
