package otus.moryakovdv.meteousers.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteousers.model.AirCompany;
import reactor.core.publisher.Mono;

/** Рест- Контроллер для пользователей */
@RestController
@Slf4j
public class MeteoUserController {

	public Mono<AirCompany> createAirCompany() {

		return Mono.empty();

	}

	public Mono<AirCompany> updateAirCompany() {

		return Mono.empty();

	}
	
	public void deleteAirCompany() {
		
		
		
	}
	
	public Mono<AirCompany> createMetBank() {

		return Mono.empty();

	}

	public Mono<AirCompany> updateMetBank() {

		return Mono.empty();

	}
	
	public void deleteMetBank() {
		
		
		
	}


}
