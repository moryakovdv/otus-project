package otus.moryakovdv.meteoinformation.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;
import otus.moryakovdv.meteoinformation.model.MeteoProduct;
import reactor.core.publisher.Mono;

/** Рест- Контроллер */
@RestController
@Slf4j
public class MeteoinformationController {

	public Mono<Airfield> createAirfield() {

		return Mono.empty();
	}

	public Mono<Airfield> updateAirfield() {

		return Mono.empty();
	}

	public void deleteAirField() {
	}

	public Mono<FlightInformationRegion> createFir() {

		return Mono.empty();
	}

	public Mono<FlightInformationRegion> updateFir() {
		return Mono.empty();
	}

	public void deleteFir() {
	}

	public Mono<MeteoProduct> createProduct() {
		
		return Mono.empty();
	}

	public Mono<MeteoProduct>  updateProduct() {
		
		return Mono.empty();
	}

	public void deleteProduct() {
	}

}
