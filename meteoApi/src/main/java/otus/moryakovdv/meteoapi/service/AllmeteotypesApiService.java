package otus.moryakovdv.meteoapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoapi.web.AllmeteotypesApiDelegate;

/***Имплементация интерфейса AllmeteotypesApiDelegate*/
@Service
@Slf4j
public class AllmeteotypesApiService implements AllmeteotypesApiDelegate {
	
	
	@Override
	@Observed(name = "loadAllMeteoTypes", contextualName = "load-all-meteotypes-with-limit")
	public ResponseEntity<Void> loadAllMeteoTypes(Integer limit) {
		
		log.info("loadAllMeteoTypes called");
		return ResponseEntity.ok().build();
		
	}
	

}
