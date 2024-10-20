package otus.moryakovdv.meteoinformation.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** Сущность ААэродром */
@Entity
@DiscriminatorValue("AIRFIELD")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class Airfield extends Origin {

	@ManyToOne
	private FlightInformationRegion fir;
	private String iataCode;
	private String country;

}
