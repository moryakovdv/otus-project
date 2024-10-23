package otus.moryakovdv.meteoproducers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** Сущность ForeighMETProducer*/
@Entity
@Table(name = "FOREIGNMETP")
@EqualsAndHashCode(of = { "id" })
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class ForeighMETProducer extends METPProducer {

	private String region;


}
