package otus.moryakovdv.meteoservices.service;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import otus.moryakovdv.meteoservices.rabbit.RabbitConfiguration;

/***Класс обеспечения подписок на очереди сообщений в RabbitMQ**/
@Service
public class SubscriptionService implements MeteoServiceModule {

	@Autowired
	private RabbitConfiguration rabbitConfiguration;
	
	public FanoutExchange getAllMeteofanoutExchange() {
		
		return rabbitConfiguration.fanoutAllMeteo;
		
	}

}
