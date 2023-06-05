package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sizes")
@Getter
@Setter
public class SizeM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "size_name", columnDefinition = "varchar(15)", nullable = false)
	protected String name;

	@Getter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy = "color")
	@JsonIgnoreProperties(value={
			"size"
	})
	protected List<ReserveM> reserves;
	@ManyToMany
	protected List<ProductM> products;
>>>>>>> Stashed changes
}
