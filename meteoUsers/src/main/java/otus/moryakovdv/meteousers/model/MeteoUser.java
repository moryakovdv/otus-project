package otus.moryakovdv.meteousers.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="meteouser_discriminator", discriminatorType=DiscriminatorType.STRING, length=20)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class MeteoUser {
	
	@Id
	@SequenceGenerator(name = "meteouser_seq", sequenceName = "meteouser_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meteouser_seq")
	private long id;
	
	private String icaoCode;
	private String name;
	private String country;

}
