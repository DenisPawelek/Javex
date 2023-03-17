package pl.javex.LOG;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLogR extends JpaRepository<AdminLogM, Long> {

}
