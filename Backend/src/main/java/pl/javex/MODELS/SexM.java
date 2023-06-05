package pl.javex.MODELS;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Table(name = "sex")
@Getter
@Setter
public class SexM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "sex_name", columnDefinition = "varchar(15)", nullable = false)
	protected String name;

	@Getter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy = "sex")
	protected List<ProductM> products;
}
