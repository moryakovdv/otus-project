package otus.moryakovdv.meteoinformation.model;

import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** Сущность РПИ */
@Entity
@DiscriminatorValue("FIR")
@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class FlightInformationRegion extends Origin {

	@OneToMany
	private Set<Airfield> airfields;
	
	private String regionCoordinates;
}
