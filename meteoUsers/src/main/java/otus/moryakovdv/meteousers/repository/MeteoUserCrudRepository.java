package otus.moryakovdv.meteousers.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import otus.moryakovdv.meteousers.model.MeteoUser;

/**Spring JPA репозиторий для работы с сущностью USER*/
@Repository
public interface MeteoUserCrudRepository extends CrudRepository<MeteoUser, Long> {
	
	Optional<MeteoUser> findById(long id);
	
	

	
	
	
}