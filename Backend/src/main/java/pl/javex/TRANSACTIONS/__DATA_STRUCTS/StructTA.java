package pl.javex.TRANSACTIONS.__DATA_STRUCTS;

import lombok.Getter;
import lombok.Setter;
import pl.javex.MODELS.AddressM;
import pl.javex.MODELS.CityM;
import pl.javex.MODELS.PostalCodeM;

@Getter
@Setter
public class StructTA {

	protected AddressM address;
	protected PostalCodeM postalCode;
	protected CityM city;
}
