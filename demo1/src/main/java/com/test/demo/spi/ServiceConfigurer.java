package com.test.demo.spi;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

import com.test.demo.exception.FailureException;
import com.test.demo.exception.TransformException;
import com.test.demo.service.OrderService;


@Configuration
@EnableJms
public class ServiceConfigurer implements JmsListenerConfigurer, ApplicationContextAware {


	private Logger logger = LoggerFactory.getLogger(ServiceConfigurer.class);

	private final Map<String, IClient> clients = new ConcurrentHashMap<>();

	private final Map<String, IPeer> peers = new ConcurrentHashMap<>();

	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
			Map<String, IClient> configuredClients = applicationContext.getBeansOfType(IClient.class, false, true);
			for (Map.Entry<String, IClient> clientEntry : configuredClients.entrySet()) {
				IClient client = clientEntry.getValue();
				String serviceName = client.getName();
				logger.info("Register client service: " + serviceName);
				System.err.println("Register client service: " + serviceName);
				clients.put(serviceName, client);
			}

			Map<String, IPeer> configuredPeers = applicationContext.getBeansOfType(IPeer.class, false, true);
			for (Map.Entry<String, IPeer> peerEntry : configuredPeers.entrySet()) {
				IPeer peer = peerEntry.getValue();
				String peerName = peer.getName();
				logger.info("Register peer: " + peerName);
				System.err.println("Register peer: " + peerName);
				peers.put(peerName, peer);
			}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		for (Map.Entry<String, IClient> entry : clients.entrySet()) {
			String destination = entry.getKey();
			IClient client = entry.getValue();
			if (client instanceof IAsyncClient) {
				// expose as JMS service
				IAsyncClient asynClient = (IAsyncClient) client;
				SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
				String id = client.getFullName();
				endpoint.setId(id);
				endpoint.setDestination(destination);
				endpoint.setMessageListener(new MessageListener() {
					@Override
					public void onMessage(Message msg) {
						logger.info("Receive message {}", id);
						try {
							if (asynClient instanceof IStableClient) {
								((IStableClient) asynClient).sendMessage(msg, false);
							} else {
								asynClient.sendMessage(msg);
							}
						} catch (TransformException | FailureException e) {
							logger.error(e.getMessage(), e);
						}
					}
				});
				registrar.registerEndpoint(endpoint);
			}
		}

	}

	public IClient getClient(String fullName) {
		return clients.get(fullName);
	}

	public IPeer getPeer(String name) {
		return peers.get(name);
	}

}
