package pl.javex.TRANSACTIONS.__DATA_STRUCTS;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
//import pl.javex.MODELS.DescriptionM;
import pl.javex.MODELS.ProductM;
import pl.javex.MODELS.ReserveM;

@Getter
@Setter
public class StructTP {
	
	protected ProductM product;
	protected List<ReserveM> reserves;
//	protected DescriptionM description;
	
}
