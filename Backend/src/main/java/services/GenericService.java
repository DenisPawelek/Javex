package services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Serwis generyczny zawierający definicje metod: Get, Add, Modify i Delete, dla pojedyńczych i wielu obiektów. 
 * Rozszerza {@link MainService}
 * 
 * @param <E> extends {@link Object}
 */
@Service
//public class MainService<E, JpaRepository<E, Long>>{
public class GenericService<E extends Object> extends MainService<E> {
//	public class MainService<E, R extends JpaRepository<E, Long>>{

	@Autowired
	private JpaRepository<E, Long> repo;

	private E f;

	public E getField() {
		return f;
	}

	public List<E> getAllItems() {
		return repo.findAll();
	}

	public E getOneItem(Long id) {
		return (E) repo.findById(id);
	}

	public E AddItem(E Item) {
		return repo.save(Item);
	}

	public void AddItems(List<E> Items) {
		repo.saveAll(Items);
	}

	public void DeleteItem(Long id) {
		repo.deleteById(id);

	}

	public void DeleteManyItems(List<Long> ids) {
		repo.deleteAllById(ids);
	}

	public void DeleteItems(List<E> Items) {
		repo.deleteAll(Items);
	}

	// MUSI DOSTAĆ PEŁNY ITEM I H.
	public List<String> ModifyItem(Long id, E item) throws IllegalAccessException, InvocationTargetException,
			NoSuchFieldException, SecurityException, NoSuchMethodException {
		List<String> str = new ArrayList<String>();
		E prew = repo.getById(id);
		if (!prew.equals(null)) {
//			Field[] f = item.getClass().getFields();
//			Method[] m = DescriptionM.class.getMethods();
//			
//			for(int i = 0; i < m.length; i++) {
//				str.add(m[i].getName().toString());
//				if(m[i].getName().toUpperCase().equals("SETID"))
//				{
//					//m[i].invoke(item, id);
//					//repo.save(item);
//					//return str;
//				}
//				
//			}
			Method m = item.getClass().getMethod("setId", Long.class);
//			m.setAccessible(true);
			m.invoke(item, id);
			// str.add(DescriptionM.class.getMethod( "setId" , Long.class).toString());
//			DescriptionM d = new DescriptionM();

			repo.save(item);

		}
		return str;
	}

	public void ModifyItems(List<Long> ids, List<E> items) throws IllegalAccessException, InvocationTargetException,
			NoSuchFieldException, SecurityException, NoSuchMethodException {
		for (int i = 0; i < items.size(); i++) {

			ModifyItem(ids.get(i), items.get(i));

		}

	}

}
