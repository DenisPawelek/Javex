package pl.javex.MODELS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter @Setter public class InvoiceM {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
}
