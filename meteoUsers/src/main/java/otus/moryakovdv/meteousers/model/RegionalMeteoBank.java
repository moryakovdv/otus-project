package otus.moryakovdv.meteousers.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**Сущность региональный метеобанк*/
@Entity
@DiscriminatorValue("REGIONALBANK")
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class RegionalMeteoBank extends MeteoUser {
	
	/**Адрес (индекс) в ВМО*/
	public String wmoAddress;
	
}
