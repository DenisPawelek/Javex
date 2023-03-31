package pl.javex.Product.Sweater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweaterR extends JpaRepository<SweaterM, Long>{

}
