package ar.edu.centro8.td1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Users;

public interface CanalRepository extends JpaRepository<Canal, Long> {

    boolean existsByNombreCanal(String nombreCanal);
    
    Optional<Canal> findByNombreCanal(String nombreCanal);
    
    List<Canal> findByNombreCanalContainingIgnoreCase(String nombreCanal);

    List<Canal> findByUser(Users user);
    

}
