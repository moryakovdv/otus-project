package otus.moryakovdv.meteoproducers.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoproducers.model.MeteoProducer;

/**Spring JPA репозиторий для работы с сущностью MeteoProducerEntity*/
@Repository
public interface ProducerRepository extends CrudRepository<MeteoProducer, Long> {
	
	Optional<MeteoProducer> findById(long id);
	Optional<MeteoProducer> findByIcaoCode(String code);

	
	
}