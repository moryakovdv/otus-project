package otus.moryakovdv.meteoinformation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoinformation.model.Airfield;

/**Spring JPA репозиторий для работы с сущностью*/
@Repository
public interface FIRCrudRepository extends CrudRepository<Airfield, Long> {
	
	Optional<Airfield> findById(long id);
	
	

	
	
	
}