package ar.edu.centro8.td1.services;

import java.util.List;
import java.util.Optional;

import ar.edu.centro8.td1.Enum.TipoReproduccion;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Reproduccion;
import ar.edu.centro8.td1.model.Users;

public interface ReproduccionServices {

Reproduccion iniciarReproduccion(Users usuario, Contenido contenido, String dispositivo, TipoReproduccion tipoReproduccion, String calidad);
    
     Reproduccion pausarReproduccion(Long reproduccionId);

     Reproduccion reanudarReproduccion(Long reproduccionId, int tiempoReanudacion);

     Reproduccion finalizarReproduccion(Long reproduccionId, float porcentajeCompletado);

     List<Reproduccion> obtenerReproduccionesPorUsuario(Users usuario);

    Optional<Reproduccion> obtenerReproduccionPorId(Long id);

}
