package pl.javex.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeR extends JpaRepository<SizeM, Long>{

}
