package ar.edu.centro8.td1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Seguimiento;
import ar.edu.centro8.td1.model.Users;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
    
    // Buscar todos los seguimientos de un usuario
    List<Seguimiento> findByUser(Users user);  // Cambié "findByUsuario" por "findByUser"

    Optional<Seguimiento> findByUserAndCanal(Users user, Canal canal);

    // Verificar si un usuario sigue a un canal
    boolean existsByUserAndCanal(Users user, Canal canal);
    @Query("SELECT s FROM Seguimiento s WHERE s.canal.nombreCanal = :nombreCanal")
    List<Seguimiento> findByCanalNombreCanal(@Param("nombreCanal") String nombreCanal);
    List<Canal> findByNombreCanalContainingIgnoreCase(String nombreCanal);
    List<Seguimiento> findByCanal_NombreCanalContainingIgnoreCase(String nombreCanal);


}
