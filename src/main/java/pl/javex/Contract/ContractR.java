package pl.javex.Contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractR extends JpaRepository<ContractM, Long>{

}
