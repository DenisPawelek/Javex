package pl.javex.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeR extends JpaRepository<TypeM, Long>{

}
