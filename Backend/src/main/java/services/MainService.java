package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
//public class MainService<E, JpaRepository<E, Long>>{
	public class MainService<E extends Object>{
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

	

}
