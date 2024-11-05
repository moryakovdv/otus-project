package otus.moryakovdv.meteoproducers.service;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@ComponentScan(basePackages = {"otus.moryakovdv.meteoservices.service", "otus.moryakovdv.meteoservices.rabbit"})
public class MQListenerService {

	private static final String producersFanoutQueue = "fanout.listener.producers";
    
    @Autowired
    private otus.moryakovdv.meteoservices.service.SubscriptionService subscriptionService;

    @Bean 
	public Declarables fanoutBindings() {
		
	    FanoutExchange fanoutExchange = subscriptionService.getAllMeteofanoutExchange();
	    Queue fanoutQueue = new Queue(producersFanoutQueue, false);

	    return new Declarables(
	    
	      fanoutQueue,
	      BindingBuilder.bind(fanoutQueue).to(fanoutExchange)
	      );
	    
	}
	
	
    /**метод слушателя очереди FanOut**/
	@RabbitListener(queues = {producersFanoutQueue})
	@Observed(name = "alive-message-received", contextualName = "alive-message-received")
	public void mqMessageListener(String message) {
		
		log.info("MQ Message received {}",message);
			
	}
	
}
