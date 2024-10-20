package otus.moryakovdv.meteoinformation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoinformation.model.Airfield;
import otus.moryakovdv.meteoinformation.model.FlightInformationRegion;

/**Spring JPA репозиторий для работы с сущностью Airfield*/
@Repository
public interface AirfieldCrudRepository extends CrudRepository<Airfield, Long> {
	
	Optional<Airfield> findById(long id);
	
	Optional<Airfield> findByIcaoCode(String icaoCode);


	
	
	
}