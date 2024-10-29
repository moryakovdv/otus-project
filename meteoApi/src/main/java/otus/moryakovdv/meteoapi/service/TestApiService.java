package otus.moryakovdv.meteoapi.service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoapi.web.TestApiDelegate;

/*** Имплементация интерфейса TestApiDelegate */
@Service
@Slf4j
public class TestApiService implements TestApiDelegate {

	@Override
	@Observed(name = "testGet", contextualName = "test-api-call")
	public ResponseEntity<String> testGet() {

		log.info("Test API method called");

		timeLimitedTestMethod();

		return ResponseEntity.ok("It works");
	}

	@TimeLimiter(name = "COMMON-TIME-LIMITER")
	private CompletableFuture<String> timeLimitedTestMethod() {

		return CompletableFuture.supplyAsync(() -> {

			Random rnd = new Random();
			int delay = rnd.nextInt(1500, 2500);
			log.info("Sleep for {} ms",delay);
			try {
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException e) {
				log.error("Sleep interrupted ", e);
			}
			
			return "Test future finished";

		});

	}

}
