package pl.javex.Product.Jacket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketR extends JpaRepository<JacketM, Long>{

}
