package ar.edu.centro8.td1.services.Implements;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.centro8.td1.Enum.EstadoReproduccion;
import ar.edu.centro8.td1.Enum.TipoReproduccion;
import ar.edu.centro8.td1.Repository.ReproduccionRepository;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Reproduccion;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.ReproduccionServices;

@Service
public class ImplementacionServicioReproduccion  implements ReproduccionServices{

    @Autowired
    private ReproduccionRepository reproduccionRepository;
   

    // Crear una nueva reproducción
    public Reproduccion iniciarReproduccion(Users usuario, Contenido contenido, String dispositivo, TipoReproduccion tipoReproduccion, String calidad) {
    Reproduccion reproduccion = new Reproduccion();
    reproduccion.setUsuario(usuario);
    reproduccion.setContenido(contenido);
    reproduccion.setFechaReproduccion(LocalDateTime.now());
    reproduccion.setDuracion(contenido.getDuracion());
    reproduccion.setEstado(EstadoReproduccion.INICIADA);  // Usar el Enum
    reproduccion.setPorcentajeCompletado(0.0f);  // Inicia desde el 0%
    reproduccion.setTipoReproduccion(tipoReproduccion);  // Usar el Enum
    reproduccion.setCalidad(calidad);
    reproduccion.setDispositivo(dispositivo);
    reproduccion.setTiempoReanudacion(0);  // Por defecto en 0 si no se reanudó
    return reproduccionRepository.save(reproduccion);
}

public Reproduccion pausarReproduccion(Long reproduccionId) {
    Optional<Reproduccion> optionalReproduccion = reproduccionRepository.findById(reproduccionId);
    if (optionalReproduccion.isPresent()) {
        Reproduccion reproduccion = optionalReproduccion.get();
        reproduccion.setEstado(EstadoReproduccion.PAUSADA);  // Usar el Enum
        return reproduccionRepository.save(reproduccion);
    }
    return null;
}


    // Reanudar una reproducción
    public Reproduccion reanudarReproduccion(Long reproduccionId, int tiempoReanudacion) {
        Optional<Reproduccion> optionalReproduccion = reproduccionRepository.findById(reproduccionId);
        if (optionalReproduccion.isPresent()) {
            Reproduccion reproduccion = optionalReproduccion.get();
            reproduccion.setEstado(EstadoReproduccion.REANUDADA);  // Usar el Enum
            reproduccion.setTiempoReanudacion(tiempoReanudacion);
            return reproduccionRepository.save(reproduccion);
        }
        return null;
    }
    

    // Finalizar una reproducción
    public Reproduccion finalizarReproduccion(Long reproduccionId, float porcentajeCompletado) {
        Optional<Reproduccion> optionalReproduccion = reproduccionRepository.findById(reproduccionId);
        if (optionalReproduccion.isPresent()) {
            Reproduccion reproduccion = optionalReproduccion.get();
            reproduccion.setEstado(EstadoReproduccion.FINALIZADA);  // Usar el Enum
            reproduccion.setPorcentajeCompletado(porcentajeCompletado);  // Actualizar el porcentaje completado
            return reproduccionRepository.save(reproduccion);
        }
        return null;
    }
    

    // Obtener las reproducciones por usuario
    public List<Reproduccion> obtenerReproduccionesPorUsuario(Users usuario) {
        return reproduccionRepository.findByUsuario(usuario);
    }

    // Obtener una reproducción específica
    public Optional<Reproduccion> obtenerReproduccionPorId(Long id) {
        return reproduccionRepository.findById(id);
    }
}
