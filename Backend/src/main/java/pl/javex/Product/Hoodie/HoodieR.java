package pl.javex.Product.Hoodie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoodieR extends JpaRepository<HoodieM, Long> {

}
