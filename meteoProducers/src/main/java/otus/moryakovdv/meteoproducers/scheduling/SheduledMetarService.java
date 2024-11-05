package otus.moryakovdv.meteoproducers.scheduling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;


/***Сервис выпуска сводки типа METAR.
 * По регламенту, для каждого аэродрома раз в 30 минут должн быть выпущена сводка фактической погоды.
 * */

@Service
@Slf4j
public class SheduledMetarService {
	
	
	@Scheduled(zone = "UTC", cron="* 30 * * * *")
	@Observed(name="metar-scheduled", contextualName ="metar-scheduled" )
	public void issueMetar() {
		
		log.info("Issuing a METAR");
		
	}

}
