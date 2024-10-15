package otus.moryakovdv.meteousers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**Сущность Пользователь*/
@Entity
@Table(name = "AIRCOMPANY")
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
public class AirCompany implements MeteoUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	


}
