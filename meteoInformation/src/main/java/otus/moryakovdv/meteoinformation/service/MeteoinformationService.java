package otus.moryakovdv.meteoinformation.service;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;
import otus.moryakovdv.meteoinformation.model.MeteoProduct;
import otus.moryakovdv.meteoinformation.model.MeteoProductType;
import otus.moryakovdv.meteoinformation.model.Origin;
import otus.moryakovdv.meteoinformation.repository.AirfieldCrudRepository;
import otus.moryakovdv.meteoinformation.repository.FIRCrudRepository;
import otus.moryakovdv.meteoinformation.repository.MeteoProductRepository;

@Service
@Slf4j
/** Сервис */
public class MeteoinformationService {

	@Autowired
	private AirfieldCrudRepository airRep;

	@Autowired
	private FIRCrudRepository firRep;

	@Autowired
	private MeteoProductRepository productRep;
	
	/**Новая сводка метеоинформации**/
	public MeteoProduct createNewProduct(MeteoProductType type, Instant issueTime, String issuer, Origin origin, String content) {

		MeteoProduct product = MeteoProduct.builder()
				.type(type)
				.issueTime(issueTime)
				.issuer(issuer)
				.origin(origin)
				.content(content)
				.build();
		
		return productRep.save(product);
				
	}

	/**загрузка сводок по аэродрому/региону*/
	public Collection<MeteoProduct> loadProductsByType(MeteoProductType type, Origin origin) {

		
		return productRep.findAllByTypeAndOrigin(type, origin);
				
	}
	

}
