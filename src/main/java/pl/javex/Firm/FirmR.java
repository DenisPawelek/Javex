package pl.javex.Firm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmR extends JpaRepository<FirmM, Long> {

}
