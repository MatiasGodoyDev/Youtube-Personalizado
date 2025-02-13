package ar.edu.centro8.td1.services;

import java.util.List;

import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Users;

public interface ContenidoServices {
    
    Contenido subirContenido(Users user, String titulo, String descripcion, String categoria, String tipoContenido, int duracion, List<String> etiquetas, String miniatura);

    void eliminarContenido(Users user, Long contenidoId);

    Contenido editarContenido(Users user, Long contenidoId, String nuevoTitulo, String nuevaDescripcion, String nuevaCategoria, String nuevoTipoContenido, int nuevaDuracion, List<String> nuevasEtiquetas);

}