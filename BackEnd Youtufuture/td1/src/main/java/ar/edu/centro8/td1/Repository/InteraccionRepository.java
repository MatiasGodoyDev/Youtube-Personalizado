package ar.edu.centro8.td1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Interaccion;
import ar.edu.centro8.td1.model.Users;

public interface InteraccionRepository extends JpaRepository<Interaccion ,Long>{

    // Método para obtener interacciones por usuario
    List<Interaccion> findByUsuario(Users usuario);

    // Método para obtener interacciones por contenido
    List<Interaccion> findByContenido(Contenido contenido);

}
