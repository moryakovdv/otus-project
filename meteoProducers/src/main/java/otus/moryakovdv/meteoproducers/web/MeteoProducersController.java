package otus.moryakovdv.meteoproducers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoproducers.model.MeteoProducer;
import otus.moryakovdv.meteoproducers.service.MeteoProducersService;

/** Контроллер, обеспечивающий вызов веб-методов **/
@RestController
@Slf4j
public class MeteoProducersController {

	@Autowired
	private MeteoProducersService mpService;
	
	@GetMapping(path = "createProducer")
	public MeteoProducer createMeteoProducer(@RequestParam String name, @RequestParam String type) {
		
		return mpService.createProducer().get();
	}
	

}
