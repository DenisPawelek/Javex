package pl.javex.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionR extends JpaRepository<DescriptionM, Long> {

}
