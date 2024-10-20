package otus.moryakovdv.meteoinformation.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;
import otus.moryakovdv.meteoinformation.repository.AirfieldCrudRepository;
import otus.moryakovdv.meteoinformation.repository.FIRCrudRepository;
import otus.moryakovdv.meteoinformation.repository.MeteoProductRepository;

@Service
@Slf4j
/** Сервис */
public class FIRService {

	@Autowired
	private AirfieldCrudRepository airRep;

	@Autowired
	private FIRCrudRepository firRep;

	@Autowired
	private MeteoProductRepository productRep;

	/** новый FIR */
	public FlightInformationRegion createNewFIR(String icaoCode, Set<Airfield> airfields) {

		FlightInformationRegion fir = FlightInformationRegion.builder()
				.icaoCode(icaoCode)
				.airfields(null).build();
		
		return firRep.save(fir);

	}

	/** поиск FIR */
	public Optional<FlightInformationRegion> findFIR(String icaoCode) {

		return firRep.findByIcaoCode(icaoCode);

	}

}
