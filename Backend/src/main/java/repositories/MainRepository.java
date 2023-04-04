package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository<T> extends JpaRepository<T, Long>{
    
}
