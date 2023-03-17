package pl.javex.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressR extends JpaRepository<AddressM, Long> {

}
