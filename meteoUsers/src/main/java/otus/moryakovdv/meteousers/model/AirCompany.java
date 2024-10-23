package otus.moryakovdv.meteousers.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**Сущность Авиакомпании*/
@Entity
@DiscriminatorValue("AIRCOMPANY")
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class AirCompany extends MeteoUser {

	private String iataCode;	
}
