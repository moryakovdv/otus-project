package otus.moryakovdv.meteoservices.cache;

import java.util.WeakHashMap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import otus.moryakovdv.meteoinformation.service.MeteoinformationService;

/** Имплементация кеширования фактической погоды на аэродроме. **/
@Service
@ComponentScan(basePackages = { "otus.moryakovdv.meteoinformation.service" })
public class MetarCacheImplementation implements CacheService<String, String> {

	private MeteoinformationService meteoInformationService;
	
	private WeakHashMap<String, String> cachedMetarsByIcao = new WeakHashMap<>();

	
	
	@Override
	public String getFromCache(String icaoCode) {

		return cachedMetarsByIcao.getOrDefault(icaoCode, retrieveMetarFromProducer(icaoCode));
	}

	@Override
	public String putInCache(String icaoCode, String metar) {
		return cachedMetarsByIcao.put(icaoCode, metar);
	}

	/** Запрос общего хранилища на получение актуального метара по аэродрому с обновлением кеша*/
	private String retrieveMetarFromProducer(String icaoCode) {

		String lastMetar = meteoInformationService.getMetarByIcao(icaoCode);
		putInCache(icaoCode, lastMetar);
		return lastMetar;
		
	}

}
