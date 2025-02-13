package ar.edu.centro8.td1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.centro8.td1.model.Reproduccion;
import ar.edu.centro8.td1.model.Users;

public interface ReproduccionRepository extends JpaRepository<Reproduccion,Long> {

    List<Reproduccion> findByUsuario(Users usuario);
}
