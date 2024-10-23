package otus.moryakovdv.meteoproducers.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoproducers.model.METPProducer;

/**Spring JPA репозиторий для работы с сущностью MeteoProducerEntity*/
@Repository
public interface ProducerRepository extends CrudRepository<METPProducer, Long> {
	
	Optional<METPProducer> findById(long id);
	Optional<METPProducer> findByIcaoCode(String code);

	
	
}