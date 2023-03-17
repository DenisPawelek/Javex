package pl.javex.User.Admin.StdAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdAdminR extends JpaRepository<StdAdminM, Long> {

}
