package pl.javex.TRANSACTIONS.__FACTORIES;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Getter;
import pl.javex.MODELS.BootsM;
import pl.javex.MODELS.HoodieM;
import pl.javex.MODELS.JacketM;
import pl.javex.MODELS.PantsM;
import pl.javex.MODELS.ProductM;
import pl.javex.MODELS.ShirtM;
import pl.javex.MODELS.SweaterM;
import services.GenericService;

@Component
public class ProductFactory {

	protected ProductM parentObj;
	protected ProductM product;
	
	
	protected factoryDelegate fd;
	protected GenericService service;
	protected Class c;
	protected int selection;
	
	
	
	
	public void setupBooleans(Boolean a, Boolean b) {fd.setupBooleans(a, b, product);}
	public void setupParent(ProductM parent) {this.parentObj = parent;}
	public void setupProduct(GenericService gs) {
		this.service = gs;
		this.c = service.getField().getClass();
		String cName = c.getSimpleName();
		
		switch(cName) {
		case "BootsM":		this.selection = 1; fd = (Boolean a, Boolean b, Object 	prod)->{((	BootsM		)prod).setHasTie(a);}										;	break;
		case "HoodieM": 	this.selection = 2; fd = (Boolean a, Boolean b, Object  prod)->{((	HoodieM		)prod).setHasHood(a); 	((HoodieM)prod).setHasZip(b);}		;	break;
		case "JacketM": 	this.selection = 3; fd = (Boolean a, Boolean b, Object  prod)->{((	JacketM		)prod).setHasHood(a); 	((JacketM)prod).setHasZip(b);}   	;	break;
		case "PantsM": 		this.selection = 4; fd = (Boolean a, Boolean b, Object 	prod)->{((	PantsM		)prod).setIsLong(a);}					   					; 	break;
		case "SweaterM": 	this.selection = 5; fd = (Boolean a, Boolean b, Object  prod)->{((	SweaterM	)prod).setHasGolf(a); 	((SweaterM)prod).setHasSleeve(b);}	;	break;
	    case "ShirtM": 		this.selection = 6; fd = (Boolean a, Boolean b, Object 	prod)->{((	ShirtM		)prod).setHasSleeve(a); ((ShirtM)prod).setHasPrint(b);}		;	break;
	    }
		
		this.product = (ProductM) gs.getField();
	}
	
	public void injectParent() 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, InvocationTargetException {
		
		
		ProductM prod = this.product;
		Class sup = c.getSuperclass();
	
		
		List<Field> fields = Arrays.stream(sup.getDeclaredFields())
				.filter(f -> Modifier.isProtected(f.getModifiers()))
				  .collect(Collectors.toList());
		

		List<String> names = new ArrayList<String>();
		for(Field f : fields) {
			String str = f.getName();
			names.add(str.substring(0, 1).toUpperCase() + str.substring(1));
		}
				
		Method[] methods = sup.getDeclaredMethods();
		List<Method> setters = new ArrayList<Method>();
		List<Method> getters = new ArrayList<Method>();
		
		for(int i = 0; i < methods.length; i++) {
			for(String name : names) {
				if(methods[i].getName().equals("set"+name)) {
					setters.add(methods[i]);
					getters.add(sup.getMethod("get"+name));
					break;
				}
			}
		}
		
		for(int i = 0; i < names.size(); i++) {
			setters.get(i).
			invoke(prod, getters.get(i).invoke(parentObj));
		}
	
	}
	
	public Object getProduct() {
		return (Object)this.product;
	};
	
	
	
}

interface factoryDelegate{
	public void setupBooleans(Boolean a, Boolean b, Object prod);
}







