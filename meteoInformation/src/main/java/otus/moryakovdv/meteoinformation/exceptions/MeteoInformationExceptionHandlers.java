package otus.moryakovdv.meteoinformation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoinformation.web.AirFieldsController;
import otus.moryakovdv.meteoinformation.web.FIRController;

/**Класс перехвата исключений для различных контроллеров**/

@Slf4j
@ControllerAdvice(assignableTypes = {AirFieldsController.class,
		FIRController.class, 
		MeteoInformationExceptionHandlers.class})
public class MeteoInformationExceptionHandlers {
	
	@ExceptionHandler(RequestNotPermitted.class)
	public ResponseEntity<String> requestNotPermittedExceptionHandler(HttpServletRequest request,
			RequestNotPermitted e) {
		log.warn("Too many requests triggered");
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
	}

	@ExceptionHandler(CallNotPermittedException.class)
	public ResponseEntity<String> callNotPermittedExceptionHandler(HttpServletRequest request,
			CallNotPermittedException e) {
		log.warn("Call not permitted by Circuit breaker");
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Circuit breaker CLOSED");
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentExceptionHandler(HttpServletRequest request,
			IllegalArgumentException e) {
		log.warn(e.getMessage());
		return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body("No sufficient data\n"+e.getMessage());
	}

}
