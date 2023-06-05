package pl.javex.TRANSACTIONS;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import pl.javex.MODELS.BootsM;
import pl.javex.MODELS.DescriptionM;
import pl.javex.MODELS.HoodieM;
import pl.javex.MODELS.JacketM;
import pl.javex.MODELS.PantsM;
import pl.javex.MODELS.ProductM;
import pl.javex.MODELS.ReserveM;
import pl.javex.MODELS.ShirtM;
import pl.javex.MODELS.SweaterM;
import pl.javex.TRANSACTIONS.__DATA_STRUCTS.StructTP;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_ObjectIDNotNull;
import pl.javex.TRANSACTIONS.__ERROR_TYPES.E_ProductClassNotMatch;
import pl.javex.TRANSACTIONS.__FACTORIES.ProductFactory;
import pl.javex.TRANSACTIONS.__INTERFACES.IProduct;
import services.GenericService;

@Component
public class ProductTransactional{
	
//	DLA PÓL
	
	@Autowired JpaRepository<DescriptionM  , Long> r_desccription;
	@Autowired JpaRepository<ReserveM      , Long> r_reserve;
	
	
	/// ################ 	MUSI BYĆ W KOLEJNOŚCI ALFABETYCZNEJ
	String [] types = {
		"boots",
		"hoodie",
		"jacket",
		"pants",
		"shirt",
		"sweater"
	};

	
	@Autowired
	public List<IProduct> IProducts;
	
	@Autowired
	ProductFactory pf;
	
	@Transactional()
	public List<String> addSingle(String t, StructTP data, Boolean a, Boolean b) 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, InvocationTargetException, SQLException {
		String s = "";
		List<String> ss = new ArrayList<String>();
		int selectedType = 0;
		for(int i = 0; i<types.length; i++) {			
			if(types[i].equals(t)) {
				
				if(data.getDescription().getId()!=null) {
					throw new E_ObjectIDNotNull("Description ID is not null", new Exception());
				}
				if(data.getProduct().getId()!=null) {
					throw new E_ObjectIDNotNull("Product ID is not null", new Exception());
				}
				if(!data.getProduct().getClass().equals(ProductM.class)) {
					throw new E_ProductClassNotMatch("Given product object is not of class ProductM", new Exception());
				}
				
				DescriptionM description = r_desccription.save(data.getDescription());
				pf.setupParent(data.getProduct());
				pf.setupProduct((GenericService)IProducts.get(i));
				pf.injectParent();
				pf.setupBooleans(a, b);
				ProductM prod = (ProductM)(pf.getProduct());
				prod.setDescription(description);
		
				prod = (ProductM)((GenericService)IProducts.get(i)).AddItem( ((GenericService)IProducts.get(i)).getField().getClass().cast((prod)));
				for(ReserveM reserve : data.getReserves()) {
					if(reserve.getId()!=null) {
						throw new E_ObjectIDNotNull("Reserve ID is not null", new Exception());
					}
					reserve.setProduct(prod);
					r_reserve.save(reserve);

				}
				

				
			}
		}

		return ss;
	}
	
}
