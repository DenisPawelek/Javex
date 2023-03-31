package pl.javex.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductR extends JpaRepository<ProductM, Long> {

}
