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

/** Сущность */
@Entity
@Table(name = "REGIONALMETPRODUCER")
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Getter
@Setter
public class RegionalMETProducer implements MeteoProducer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String icaoCode;

}
