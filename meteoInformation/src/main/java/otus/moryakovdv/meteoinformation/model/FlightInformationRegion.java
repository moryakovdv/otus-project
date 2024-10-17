package otus.moryakovdv.meteoinformation.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**Сущность РПИ*/
@Entity
@Table(name = "FIR")
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
public class FlightInformationRegion implements Origin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String icaoCode;
	private String country;	
	private Set<Airfield> airfields;

}
