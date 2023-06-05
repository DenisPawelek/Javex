package pl.javex.TRANSACTIONS.__DATA_STRUCTS;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import pl.javex.MODELS.DateM;
import pl.javex.MODELS.EmailM;
import pl.javex.MODELS.UserM;

@Getter
@Setter
public class StructTU {

	protected StructTA addressStruct;
	protected UserM user;
	protected EmailM email;
	protected Date birth;	
}
