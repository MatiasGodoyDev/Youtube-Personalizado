package ar.edu.centro8.td1.services;

import java.util.List;
import java.util.Optional;

import ar.edu.centro8.td1.Enum.EstadoInteraccion;
import ar.edu.centro8.td1.Enum.TipoInteraccion;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Interaccion;
import ar.edu.centro8.td1.model.Users;

public interface InteraccionServices {
    Interaccion crearInteraccion(Users usuario, Contenido contenido, TipoInteraccion tipoInteraccion, String comentario, boolean like, boolean notlike, boolean compartido, float rating, List<String> etiquetas, String reacciones, String origen, String urlMultimedia);


    List<Interaccion> obtenerInteraccionesPorUsuario(Users usuario);

    List<Interaccion> obtenerInteraccionesPorContenido(Contenido contenido);

    Optional<Interaccion> obtenerInteraccionPorId(Long id);

    Interaccion actualizarEstadoInteraccion(Long interaccionId, EstadoInteraccion nuevoEstado);

    void eliminarInteraccion(Long interaccionId);
}
