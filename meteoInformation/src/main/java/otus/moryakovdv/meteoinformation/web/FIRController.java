package otus.moryakovdv.meteoinformation.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;
import otus.moryakovdv.meteoinformation.model.MeteoProduct;
import otus.moryakovdv.meteoinformation.service.AirfieldService;
import otus.moryakovdv.meteoinformation.service.FIRService;
import otus.moryakovdv.meteoinformation.service.MeteoinformationService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** Рест- Контроллер */
@RestController
@Slf4j
public class FIRController {
	
	@Autowired
	private AirfieldService aService;
	
	@Autowired
	private FIRService fService;
	
	@Autowired
	private MeteoinformationService miService;
	
	
	
	@PostMapping(value = "/createFir")
	public Mono<FlightInformationRegion> createFir(@RequestParam String icaoCode) {

		FlightInformationRegion newFir = fService.createNewFIR(icaoCode, Collections.emptySet());
		return Mono.just(newFir);

	}

	public Flux<FlightInformationRegion> getFirs() {

		return Flux.empty();
	}

	public Mono<FlightInformationRegion> updateFir() {
		return Mono.empty();
	}

	public void deleteFir() {
	}


}
