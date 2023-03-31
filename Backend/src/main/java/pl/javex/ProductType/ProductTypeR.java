package pl.javex.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeR extends JpaRepository<ProductTypeM, Long>{

}
