package pl.javex.TRANSACTIONS;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
import pl.javex.TRANSACTIONS.__FACTORIES.ProductFactory;
import pl.javex.TRANSACTIONS.__INTERFACES.IProduct;
import services.GenericService;

@Component
public class ProductTransactional{
	
//	DLA PÓL
	
	@Autowired JpaRepository<DescriptionM  , Long> r_desccription;
	@Autowired JpaRepository<ReserveM      , Long> r_reserve;
	
//	DLA KLAS
	
//	@Autowired JpaRepository<ProductM      , Long> BASE;
//	@Autowired JpaRepository<BootsM        , Long> _BOOTS;
//	@Autowired JpaRepository<HoodieM       , Long> _HOODIE;
//	@Autowired JpaRepository<JacketM       , Long> _JACKET;
//	@Autowired JpaRepository<PantsM        , Long> _PANTS;
//	@Autowired JpaRepository<ShirtM        , Long> _SHIRT;
//	@Autowired JpaRepository<SweaterM      , Long> _SWEATER;
	
	/// ################ 	MUSI BYĆ W KOLEJNOŚCI ALFABETYCZNEJ
	String [] types = {
		"boots",
		"hoodie",
		"jacket",
		"pants",
		"shirt",
		"sweater"
	};
//	@Autowired
//	JpaRepository[] repos = {
//		_BOOTS,   
//		_HOODIE,  
//		_JACKET,  
//	    _PANTS,   
//	    _SHIRT,   
//	    _SWEATER
//	};
	
	@Autowired
	public List<IProduct> IProducts;
	
	@Autowired
	ProductFactory pf;
	
	@Transactional
	public List<String> addSingle(String t, StructTP data, Boolean a, Boolean b) 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, InvocationTargetException, Exception {
		String s = "";
		List<String> ss = new ArrayList<String>();
		int selectedType = 0;
		for(int i = 0; i<types.length; i++) {			
			if(types[i].equals(t)) {
				
				if(data.getDescription().getId()!=null) {
					throw new Exception("Description ID is not null");
				}
				if(data.getProduct().getId()!=null) {
					throw new Exception("Product ID is not null");
				}
				if(!data.getProduct().getClass().equals(ProductM.class)) {
					throw new Exception("Product is not ProductM");
				}
				
				
//				ProductFactory pf = ProductFactory._getInstance();
				DescriptionM description = r_desccription.save(data.getDescription());
				pf.setupParent(data.getProduct());
				pf.setupProduct((GenericService)IProducts.get(i));
				pf.injectParent();
				pf.setupBooleans(a, b);
				ProductM prod = (ProductM)(pf.getProduct());
				prod.setDescription(description);
				
				
//				BootsM prod = (BootsM)(o);
//				ss.add(prod.getDescription().getId().toString());
//				ss.add(((Long)prod.getId())+"aa");

//				Object obj = (Object)prod;
				
				
				prod = (ProductM)((GenericService)IProducts.get(i)).AddItem( ((GenericService)IProducts.get(i)).getField().getClass().cast((prod)));
//				ss.add(prod.getId()+"aa");
				for(ReserveM reserve : data.getReserves()) {
					if(reserve.getId()!=null) {
						throw new Exception("Reserve ID is not null");
					}
					reserve.setProduct(prod);
					r_reserve.save(reserve);
//					ss.add(reserve.getColor().getId()+"");
//
//					ss.add(reserve.getColor().getId()+"");
//					
//
//					ss.add(reserve.getSize().getId()+"");
				}
				
				
//				repos[i].save(((GenericService)IProducts).getField().getClass().cast(obj));
				
//				
//				
//				Class sup = prod.getClass().getSuperclass();
////				ss.add((((Boolean)((BootsM)o).isHasTie()).toString() ));
//				ss.add(prod.getClass().getSimpleName());
//				
//				List<Field> fields = Arrays.stream(sup.getDeclaredFields())
//						.filter(f -> Modifier.isProtected(f.getModifiers()))
//						  .collect(Collectors.toList());
//				List<Field> fieldss = Arrays.stream(prod.getClass().getDeclaredFields())
//						.filter(f -> Modifier.isProtected(f.getModifiers()))
//						  .collect(Collectors.toList());
//
//				fields.addAll(fieldss);
//				
//				List<String> names = new ArrayList<String>();
//				for(Field f : fields) {
//					String str = f.getName();
//					names.add(str.substring(0, 1).toUpperCase() + str.substring(1));
//				}
//						
//				List<Method> methods =  Arrays.stream(prod.getClass().getDeclaredMethods()).collect(Collectors.toList());;
//				
//				List<Method> methods2 = Arrays.stream(sup.getDeclaredMethods()).collect(Collectors.toList());;
//
//				methods.addAll(methods2);
//				
////				methods.addAll(methods1);
//				
//				for(Method m : methods) {
//					ss.add(m.getName());
//				}
//				List<Method> getters = new ArrayList<Method>();
//				
//				for(int x = 0; x < methods.size(); x++) {
//					for(String name : names) {
//						if(methods.get(x).getName().equals("get"+name)) {
//							getters.add(prod.getClass().getMethod("get"+name));
//							break;
//						}
//					}
//				}
//				
//				for(Method g : getters) {
//					ss.add("__"+g.invoke(prod).toString());
//				}
//				repos[i].save(o);
//				pf.saveObject();
				
				
//				Class c = ((GenericService)IProducts.get(i)).getField().getClass();
//				List<Field> fieldss = Arrays.stream(c.getSuperclass().getDeclaredFields())
//						.filter(f -> Modifier.isProtected(f.getModifiers()))
//						  .collect(Collectors.toList());
//				
//				List<Field> fields = Arrays.stream(c.getDeclaredFields())
//						.filter(f -> Modifier.isProtected(f.getModifiers()))
//						  .collect(Collectors.toList());
//				fields.addAll(fieldss);
//				s = "";
//				
//				List<String> getterNames = new ArrayList<String>();
//				List<String> setterNames = new ArrayList<String>();
//				
//				for(Field f : fields) {
//					String str = f.getName();
//					getterNames.add("get"+ str.substring(0, 1).toUpperCase() + str.substring(1)) ;
//					setterNames.add("set"+ str.substring(0, 1).toUpperCase() + str.substring(1)) ;
//					
//				}
//				ss.addAll(setterNames);
				
			}
		}
//		
		
		
//		ProductM prod = 	data.getProduct().setDescription(r_desccription.save(data.getDescription()));
		
//		return repos.length+"";
//		obj.setReserves(null);
//		List<ReserveM> reserves = data.getReserves();
//		String s = "";
//		for(String type : types) {
//			s=s+"|"+type;
//		}
//		s=s+"|###";
//		for(int i = 0; i<pr.size(); i++) {
//			s=s+"|"+pr.get(i).getClass().getSimpleName();
//		}
//		return s;
//		return pr.size()+"";
//		return "aaa";
//		return data.getReserves().toString();
//		return repos.getClass().getSimpleName();
		return ss;
	}
	
}
