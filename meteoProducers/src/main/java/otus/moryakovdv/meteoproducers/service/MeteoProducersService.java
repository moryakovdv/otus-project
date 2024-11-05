package otus.moryakovdv.meteoproducers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import otus.moryakovdv.meteoproducers.model.METPProducer;
import otus.moryakovdv.meteoproducers.repository.ProducerRepository;

/***Класс релизации бизнес-логики веб-сервиса**/
@Service
public class MeteoProducersService {
	
	@Autowired
	ProducerRepository producerRepo;

	
	public Optional<METPProducer> createProducer() {
		
		return Optional.empty();
		
	}
	
	public void changeProducerSchedule() {}
	


}
