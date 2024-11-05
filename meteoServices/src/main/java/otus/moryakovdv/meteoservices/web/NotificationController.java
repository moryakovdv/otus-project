package otus.moryakovdv.meteoservices.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoservices.enums.NOTIFICATION_TYPE;
import otus.moryakovdv.meteoservices.service.NotificationService;

/** Контроллер, обеспечивающий вызов веб-методов для сервиса уведомлений**/
@RestController
@Slf4j
@RequestMapping("/notification")
public class NotificationController {

	private AtomicLong requestsCount = new AtomicLong();
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping(path = "/alive", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
	@Observed(name = "alive-notiication", contextualName = "alive-notification")
	public void broadcastAliveNotification() {
		
		notificationService.notifyAliveMessage();
		log.debug("Alive packet sent");
		
		
		
	} 

}
