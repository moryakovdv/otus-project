package otus.moryakovdv.meteoproducers.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** Сущность */
@Entity
@DiscriminatorValue("REGIONALMETP")
@EqualsAndHashCode(of = { "id" })
@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class RegionalMETProducer extends METPProducer {

		private String region;
	

}
