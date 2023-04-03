package pl.javex.Product.Shirt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtR extends JpaRepository<ShirtM, Long>{

}
