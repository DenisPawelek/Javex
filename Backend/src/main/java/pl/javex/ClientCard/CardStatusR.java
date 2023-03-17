package pl.javex.ClientCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatusR extends JpaRepository<CardStatusM, Long>{

	
	
}
