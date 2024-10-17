package otus.moryakovdv.meteoproducers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import otus.moryakovdv.meteoproducers.model.MeteoProducer;
import otus.moryakovdv.meteoproducers.repository.ProducerRepository;

/***Класс релизации бизнес-логики веб-сервиса**/
@Component
public class MeteoProducersService {
	
	@Autowired
	ProducerRepository producerRepo;

	
	public Optional<MeteoProducer> createProducer() {
		
		return Optional.empty();
		
	}
	
	public void changeProducerSchedule() {}
	
	
	
	
	
	
	

}
