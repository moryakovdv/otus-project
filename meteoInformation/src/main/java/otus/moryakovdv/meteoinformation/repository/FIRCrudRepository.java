package otus.moryakovdv.meteoinformation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;

/**Spring JPA репозиторий для работы с сущностью FlightInformationRegion */
@Repository
public interface FIRCrudRepository extends CrudRepository<FlightInformationRegion, Long> {
	
	Optional<FlightInformationRegion> findById(long id);
	
	Optional<FlightInformationRegion> findByIcaoCode(String icaoCode);

	
	
	
}