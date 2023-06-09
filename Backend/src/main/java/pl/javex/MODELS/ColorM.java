package pl.javex.MODELS;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "colors")
@Getter
@Setter
public class ColorM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "color_name", columnDefinition = "varchar(31)", nullable = false)
	protected String name;

	@Getter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy = "color")
	@JsonIgnoreProperties(value={
			"color"
	})
	protected List<ReserveM> reserves;
}
