package otus.moryakovdv.meteoinformation.service;

import java.time.Instant;
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
public class AirfieldService {

	@Autowired
	private AirfieldCrudRepository airRep;

	@Autowired
	private FIRCrudRepository firRep;

	@Autowired
	private MeteoProductRepository productRep;

	/**Новый аэродром/аэропорт*/
	public Airfield createNewAirField(String icaoCode, String iataCode, String name, String country,
			FlightInformationRegion fir) {

		Airfield newAf = Airfield.builder().icaoCode(icaoCode).iataCode(iataCode).name(name).country(country).fir(fir)
				.build();

		return airRep.save(newAf);

	}

	

}
