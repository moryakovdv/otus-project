package otus.moryakovdv.meteoinformation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**Сущность ААэродром*/
@Entity
@Table(name = "AIRFIELD")
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
public class Airfield {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	

}
