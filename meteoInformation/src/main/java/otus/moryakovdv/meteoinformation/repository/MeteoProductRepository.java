package otus.moryakovdv.meteoinformation.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteoinformation.model.MeteoProduct;
import otus.moryakovdv.meteoinformation.model.MeteoProductType;
import otus.moryakovdv.meteoinformation.model.Origin;

/**Spring JPA репозиторий для работы с сущностью MeteoProduct*/
@Repository
public interface MeteoProductRepository extends CrudRepository<MeteoProduct, Long> {
	
	/**Поиск по ИД*/
	Optional<MeteoProduct> findById(long id);
	
	/**Поиск всех метеоданных определенного типа по объекту (ФИР, аэродром, и т.п.)**/
	Set<MeteoProduct> findAllByTypeAndOrigin(MeteoProductType type, Origin origin);

	
	
	
}