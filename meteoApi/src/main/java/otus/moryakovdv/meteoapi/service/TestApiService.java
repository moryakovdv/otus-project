package otus.moryakovdv.meteoapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoapi.web.TestApiDelegate;

/***Имплементация интерфейса TestApiDelegate*/
@Service
@Slf4j
public class TestApiService implements TestApiDelegate {
	
	
	@Override
	@Observed(name = "testGet", contextualName = "test-api-call")
	public ResponseEntity<Void> testGet() {
		log.info("TEst API method called");
		return ResponseEntity.ok().build();
	}
	

}
