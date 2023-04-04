package services;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
//public class MainService<E, JpaRepository<E, Long>>{
	public class GenericService<E extends Object> extends MainService<E>{
//	public class MainService<E, R extends JpaRepository<E, Long>>{

	@Autowired
	private JpaRepository<E, Long> repo;

	private E f;
	public E getField() {return f;}
	
	public List<E> getAllItems()
	{
		return repo.findAll();
	}
	
	public E getOneItem(Long id) {
		return (E)repo.findById(id);
	}
	
	public void AddItem(E Item)
	{
		repo.save(Item);
	}
	
	public void AddItems(List<E> Items)
	{
		repo.saveAll(Items);
	}
	
	public void DeleteItem(Long id)
	{
		repo.deleteById(id);
		
	}
	
	public void DeleteManyItems(List<Long> ids)
	{
		repo.deleteAllById(ids);
	}
	
	public void DeleteItems(List<E> Items)
	{
		repo.deleteAll(Items);
	}
	
	//MUSI DOSTAĆ PEŁNY ITEM I H.
	public void ModifyItem(Long id, E item) 
			throws IllegalAccessException, 
			InvocationTargetException
	{
		E prew = repo.getById(id);
		if(!prew.equals(null)) {
//			Field[] f = item.getClass().getFields();
			Method[] m = item.getClass().getDeclaredMethods();
			
			for(int i = 0; i < m.length; i++) {
				if(m[i].getName().toUpperCase().equals("SETID"))
				{
					m[i].invoke(item, id);
					repo.save(item);
					return;
				}
				
			}
			
			
		}
	}
	

	public void ModifyItems(List<Long> ids, List<E> items) 
			throws IllegalAccessException, 
			InvocationTargetException 
	{
		for(int i = 0; i < items.size(); i++ ) {
			
			ModifyItem(ids.get(i), items.get(i));
			
		}
		
		
	}
	
}
