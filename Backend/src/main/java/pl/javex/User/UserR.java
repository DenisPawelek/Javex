package pl.javex.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserR extends JpaRepository<UserM, Long> {

	
	
}
