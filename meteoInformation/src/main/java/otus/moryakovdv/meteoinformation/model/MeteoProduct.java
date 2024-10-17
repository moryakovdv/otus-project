package otus.moryakovdv.meteoinformation.model;

import java.time.Instant;
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

/**Сущность метеоинформация*/
@Entity
@Table(name = "METEOPRODUCT")
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
public class MeteoProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Origin origin;
	
	private MeteoProductType type;
	private Instant issueTime;
	private String issuer;
	private String content;
	

}
