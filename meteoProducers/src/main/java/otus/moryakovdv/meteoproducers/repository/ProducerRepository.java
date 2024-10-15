package otus.moryakovdv.meteoproducers.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoproducers.model.MeteoProducerEntity;

/**Spring JPA репозиторий для работы с сущностью MeteoProducerEntity*/
@Repository
public interface ProducerRepository extends CrudRepository<MeteoProducerEntity, Long> {
	
	Optional<MeteoProducerEntity> findById(long id);
	
	
}