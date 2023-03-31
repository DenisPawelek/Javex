package pl.javex.Sex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexR extends JpaRepository<SexM, Long>{

}
