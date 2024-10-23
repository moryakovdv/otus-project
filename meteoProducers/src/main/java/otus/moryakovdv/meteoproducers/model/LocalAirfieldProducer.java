package otus.moryakovdv.meteoproducers.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**Сущность */
@Entity
@DiscriminatorValue("LOCALAF")
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class LocalAirfieldProducer extends METPProducer {

	private String location;

	

}
