package pl.javex.TRANSACTIONS.__DATA_STRUCTS;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pl.javex.MODELS.DescriptionM;
import pl.javex.MODELS.InvoiceM;
import pl.javex.MODELS.OrderM;
import pl.javex.MODELS.UserM;

@Getter
@Setter
public class StructTT {

	UserM user;
	StructTA addressStruct;
	Date date;
	DescriptionM desc;
	InvoiceM invoice;
	List<OrderM> orders;
}
