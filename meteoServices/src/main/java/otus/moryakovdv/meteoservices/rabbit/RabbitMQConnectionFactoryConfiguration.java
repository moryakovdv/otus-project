package otus.moryakovdv.meteoservices.rabbit;

import java.io.IOException;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ChannelListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Recoverable;
import com.rabbitmq.client.RecoveryListener;
import com.rabbitmq.client.ShutdownSignalException;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RabbitMQConnectionFactoryConfiguration {

	

	@Value("${market.rabbit.host:127.0.0.1}")
	private String rabbitHost;

	@Value("${market.rabbit.port:5672}")
	private int rabbitPort;

	@Value("${market.rabbit.username:guest}")
	private String rabbitUsername;

	@Value("${market.rabbit.password:guest}")
	private String rabbitPassword;

	@Value("${market.rabbit.channelMax:8192}")
	private int channelMax;
	
	

	@Bean
	public RabbitAdmin getRabbitAdmin(CachingConnectionFactory cf) {
		
		return new RabbitAdmin(cf) {
			
			@Override
			public void afterPropertiesSet() {
				initialize();
			}
			
		};
		
	}
	
	

	@Bean
	@Primary
	public CachingConnectionFactory rabbitConnectionFactory() {

		CachingConnectionFactory cf = new CachingConnectionFactory();
		
		
		
		cf.setRecoveryListener(new RecoveryListener() {
			
			@Override
			public void handleRecoveryStarted(Recoverable recoverable) {
				log.debug("recovery started for {}",recoverable);
				
			}
			
			@Override
			public void handleRecovery(Recoverable recoverable) {
				log.debug("recovery handled for {}",recoverable);

				
			}
		});
		
		
		cf.setHost(rabbitHost);
		cf.setPort(rabbitPort);
		cf.setUsername(rabbitUsername);
		cf.setPassword(rabbitPassword);
		
		cf.addConnectionListener(new ConnectionListener() {
			
			@Override
			public void onCreate(Connection connection) {
				log.debug("Rabbit connection created {}",connection);
				
			}
			@Override
			public void onClose(Connection connection) {
				log.debug("Rabbit connection closed {}",connection);
				
			}
			
			@Override
			public void onFailed(Exception exception) {
				
				ConnectionListener.super.onFailed(exception);
				log.error("Rabbit connection FAILED ",exception);
			}
			
			@Override
			public void onShutDown(ShutdownSignalException signal) {
				
				ConnectionListener.super.onShutDown(signal);
				log.debug("Rabbit connection shutdown signal received {}",signal);
			}
			
		});
		
		
		
		cf.addChannelListener(new ChannelListener() {

			@Override
			public void onCreate(Channel channel, boolean transactional) {

				log.debug("channel created {}", channel);

			}

			@Override
			public void onShutDown(ShutdownSignalException signal) {
				ChannelListener.super.onShutDown(signal);
				log.debug("channel closed {}", signal.getReference());
			}
			
			
		});
		return cf;

	}

	@Bean
	public RabbitAdmin amqpAdmin() {
		RabbitAdmin ra = new RabbitAdmin(rabbitConnectionFactory());
		
		return ra;
	}



	@Bean
	public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

		rabbitTemplate.setUsePublisherConnection(true);
		//rabbitTemplate.setBeforePublishPostProcessors(new GZipPostProcessor());

		log.info("Rabbit producer created {}", rabbitTemplate);
		return rabbitTemplate;
	}

	

	@Bean
	@Scope("prototype")
	/***бин кастомного адаптера. 
	 * Наличие реализации этого метода в классах позволяет подписываться на очереди без использования аннотаций RabbitListener
	 * Обеспечеивает большую гибкость в реализции работы с очередями***/
	public MessageListenerAdapter messageListenerAdapter() throws IOException {

		MessageListenerAdapter adapter = new MessageListenerAdapter();
		adapter.setDefaultListenerMethod("receiveRabbitMessage");
		// adapter.setMessageConverter(jsonMessageConverter());

		return adapter;
	}

}
