package pl.javex.User.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientR extends JpaRepository<ClientM, Long> {

}
