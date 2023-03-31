package pl.javex.Product.Pants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsR extends JpaRepository<PantsM, Long>{

}
