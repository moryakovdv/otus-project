package otus.moryakovdv.meteoservices.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**Конфигурация слушателей RabbitMQ для использования маппинга сообщений через Jackson**/
@Configuration
public class RabbitMQListenersConfiguration implements RabbitListenerConfigurer {

	 @Override
	    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
	        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	    }


	 
	    @Bean
	    MessageHandlerMethodFactory messageHandlerMethodFactory() {
	        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
	        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
	        return messageHandlerMethodFactory;
	    }

	    @Bean
	    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
	    	MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    	ObjectMapper om = new ObjectMapper();
	    	
	        converter.setObjectMapper(om);
	    	
	    	return converter;
	    }
	    
	  
	


}
