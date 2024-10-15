package otus.moryakovdv.meteoservices.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

/** Контроллер, обеспечивающий вызов веб-методов **/
@Controller
@Slf4j
public class SubscriptionController {

	private AtomicLong requestsCount = new AtomicLong();

}
