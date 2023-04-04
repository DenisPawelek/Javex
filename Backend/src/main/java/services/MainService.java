package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
//public class MainService<E, JpaRepository<E, Long>>{
	public class MainService<E>{
//	public class MainService<E, R extends JpaRepository<E, Long>>{

	@Autowired
	private JpaRepository<E, Long> repo;
	
	public List<E> getAllItems()
	{
		return repo.findAll();
	}
	
	public void AddItem(E Item)
	{
		repo.save(Item);
	}
	
	public void AddItems(List<E> Items)
	{
		repo.saveAll(Items);
	}
	
	public void DeleteItem(E Item)
	{
		repo.delete(Item);
	}
	
	public void DeleteItems(List<E> Items)
	{
		repo.deleteAll(Items);
	}

	

}
