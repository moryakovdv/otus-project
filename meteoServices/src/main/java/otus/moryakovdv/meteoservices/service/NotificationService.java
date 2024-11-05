package otus.moryakovdv.meteoservices.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoservices.enums.NOTIFICATION_TYPE;
import otus.moryakovdv.meteoservices.rabbit.RabbitConfiguration;

/***Класс релизации бизнес-логики сервиса рассылки уведомлений**/
@Service
@Slf4j
public class NotificationService implements MeteoServiceModule{

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	/***Броадкастинг сообщений об изменениях через Fanout rabbitMQ*/
	@Observed(name = "notify-message-call", contextualName = "notify-message-call")
	public void notifyAllOnChanges(NOTIFICATION_TYPE type, String messageBody) {
		log.debug("Broadcasting change message {}",type);
		rabbitTemplate.convertAndSend(RabbitConfiguration.ALL_METEO_INFORMATION_FANOUT, type.toString(), messageBody);
		
	}
	@Observed(name = "alive-message-call", contextualName = "alive-message-call")
	public void notifyAliveMessage() {
		
		log.debug("Broadcasting alive message");
		rabbitTemplate.convertAndSend(RabbitConfiguration.ALL_METEO_INFORMATION_FANOUT, NOTIFICATION_TYPE.ALIVE_PACKET.toString(), "alive-message");
		
	}
	
	


}
