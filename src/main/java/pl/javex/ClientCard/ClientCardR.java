package pl.javex.ClientCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCardR extends JpaRepository<ClientCardM, Long> {

}
