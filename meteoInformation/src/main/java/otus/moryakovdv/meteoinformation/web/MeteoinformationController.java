package otus.moryakovdv.meteoinformation.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class MeteoinformationController {
	
	@Autowired
	private AirfieldService aService;
	
	@Autowired
	private FIRService fService;
	
	@Autowired
	private MeteoinformationService miService;
	
	
	@PostMapping(value = "/createProduct")
	public Mono<MeteoProduct> createProduct(@RequestBody MeteoProduct product) {
		MeteoProduct newProduct = miService.createNewProduct(product.getType(), product.getIssueTime(), product.getIssuer(), 
				
				product.getOrigin(), product.getContent()
				
				);
		return Mono.just(newProduct);

	}

	public Flux<MeteoProduct> getProducts() {

		return Flux.empty();
	}

	public Mono<MeteoProduct> updateProduct() {

		return Mono.empty();
	}

	public void deleteProduct() {
	}


}
