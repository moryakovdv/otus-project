package otus.moryakovdv.meteoservices.rabbit;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableScheduling
public class RabbitConfiguration {

	public static final String ALL_METEO_INFORMATION_FANOUT = "fanout.allmeteo";

	public static final String METAR_TOPIC = "topic.metar";
	public static final String TAF_TOPIC = "topic.taf";

	public static final String TOPIC_USERS = "topic.meteousers";
	public static final String TOPIC_PRODUCERS = "topic.meteoproducers";

	public static final String TOPIC_AIRIFELDS = "topic.airfields";
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	
	public final FanoutExchange fanoutAllMeteo = new FanoutExchange(ALL_METEO_INFORMATION_FANOUT, true, false);

	public final TopicExchange topicMetar = new TopicExchange(METAR_TOPIC, true, false);
	public final TopicExchange topicTaf = new TopicExchange(TAF_TOPIC, true, false);

	public final TopicExchange topicUsers = new TopicExchange(TOPIC_USERS, true, false);
	public final TopicExchange topicProducers = new TopicExchange(TOPIC_PRODUCERS, true, false);

	public final TopicExchange topicAirfields = new TopicExchange(TOPIC_AIRIFELDS, true, false);
	

	/** Первичное создание необходимых Exchanges */
	@Bean
	public Declarables topicBindings() {

		log.debug("Starting to create exchanges in rabbitMQ");

		return new Declarables(fanoutAllMeteo, topicMetar, topicTaf, topicUsers, topicProducers, topicAirfields);

	}
	
	public FanoutExchange getFanoutAllMeteo() {
		
		return fanoutAllMeteo;
	}

	
	
}
