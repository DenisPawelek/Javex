package pl.javex.__CUSTOM_REPOS;

import pl.javex.MODELS.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SelectProductsBy_Repo<T extends ProductM, E> extends JpaRepository<T, E>{

	@Query(value = "SELECT p FROM #{#entityName} p WHERE p.sex=:s")
	public List<T> getBySex(@Param("s") SexM s);
	
	@Query(value = "SELECT p FROM #{#entityName} p WHERE p.price>:priLow AND p.price<:priUpp")
	public List<T> getInPriceRange(@Param("priLow") Long priLow, @Param("priUpp")Long priUpp );
	
	@Query(value = "SELECT p FROM #{#entityName} p WHERE p.name like %:n%")
	public List<T> getFilterName(@Param("n") String name);
	
}
