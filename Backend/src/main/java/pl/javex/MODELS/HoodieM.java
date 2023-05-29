package pl.javex.MODELS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.text.StyledEditorKit.BoldAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hoodies")
@Getter
@Setter
public class HoodieM extends ProductM {
	@Column(name = "hood", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasHood;
	@Column(name = "zip", columnDefinition = "boolean default false", nullable = false)
	protected Boolean hasZip;
}
