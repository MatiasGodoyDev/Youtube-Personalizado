package ar.edu.centro8.td1.services.Implements;

import ar.edu.centro8.td1.model.Interaccion;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.Enum.EstadoInteraccion;
import ar.edu.centro8.td1.Enum.TipoInteraccion;
import ar.edu.centro8.td1.Repository.InteraccionRepository;
import ar.edu.centro8.td1.services.InteraccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplementacionServicioInteraccion implements InteraccionServices {

    @Autowired
    private InteraccionRepository interaccionRepository;

    // Crear una nueva interacción (como un like, comentario, etc.)
    @Override
    public Interaccion crearInteraccion(Users usuario, Contenido contenido, TipoInteraccion tipoInteraccion, String comentario, boolean like, boolean notlike, boolean compartido, float rating, List<String> etiquetas, String reacciones, String origen, String urlMultimedia) {
        Interaccion interaccion = new Interaccion();
        interaccion.setUsuario(usuario);
        interaccion.setContenido(contenido);
        interaccion.setTipoInteraccion(tipoInteraccion); // Usar el Enum TipoInteraccion
        interaccion.setComentarios(comentario);
        interaccion.setLike(like);
        interaccion.setNotlike(notlike);
        interaccion.setCompartido(compartido);
        interaccion.setRating(rating);
        interaccion.setEtiquetas(etiquetas);
        interaccion.setReacciones(reacciones);
        interaccion.setOrigen(origen);
        interaccion.setUrlMultimedia(urlMultimedia);
        interaccion.setFecha(java.time.LocalDateTime.now()); // Fecha actual
        interaccion.setEstadoInteraccion(EstadoInteraccion.ACTIVA); // Usar el Enum EstadoInteraccion

        return interaccionRepository.save(interaccion);
    }



    // Obtener interacciones por usuario
    @Override
    public List<Interaccion> obtenerInteraccionesPorUsuario(Users usuario) {
        return interaccionRepository.findByUsuario(usuario);
    }

    // Obtener interacciones por contenido
    @Override
    public List<Interaccion> obtenerInteraccionesPorContenido(Contenido contenido) {
        return interaccionRepository.findByContenido(contenido);
    }

    // Obtener interacción específica por ID
    @Override
    public Optional<Interaccion> obtenerInteraccionPorId(Long id) {
        return interaccionRepository.findById(id);
    }

    // Actualizar estado de una interacción
    @Override
    public Interaccion actualizarEstadoInteraccion(Long interaccionId, EstadoInteraccion nuevoEstado) {
    Optional<Interaccion> optionalInteraccion = interaccionRepository.findById(interaccionId);
    if (optionalInteraccion.isPresent()) {
        Interaccion interaccion = optionalInteraccion.get();
        interaccion.setEstadoInteraccion(nuevoEstado);  // Pasamos el Enum en lugar de String
        return interaccionRepository.save(interaccion);
    }
    return null;
}


    // Eliminar interacción
    @Override
    public void eliminarInteraccion(Long interaccionId) {
        interaccionRepository.deleteById(interaccionId);
    }
}
