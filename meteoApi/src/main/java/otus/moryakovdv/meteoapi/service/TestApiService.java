package otus.moryakovdv.meteoapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import otus.moryakovdv.meteoapi.web.AllmeteotypesApiDelegate;
import otus.moryakovdv.meteoapi.web.TestApiDelegate;

/***Имплементация интерфейса TestApiDelegate*/
@Service
public class TestApiService implements TestApiDelegate {
	
	
	@Override
	@Observed(name = "testGet", contextualName = "test-api-call")
	public ResponseEntity<Void> testGet() {
	
		return ResponseEntity.ok().build();
	}
	

}
