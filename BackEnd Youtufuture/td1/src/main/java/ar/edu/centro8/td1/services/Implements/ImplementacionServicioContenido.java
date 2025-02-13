package ar.edu.centro8.td1.services.Implements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.centro8.td1.Repository.CanalRepository;
import ar.edu.centro8.td1.Repository.ContenidoRepository;
import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.ContenidoServices;

@Service
public class ImplementacionServicioContenido implements ContenidoServices {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private CanalRepository canalRepository;

    
    @Override
    public Contenido subirContenido(Users user, String titulo, String descripcion, String categoria, String tipoContenido, int duracion, List<String> etiquetas, String miniatura) {
        // Verificar si el usuario tiene un canal
        List<Canal> canales = canalRepository.findByUser(user);
        
        if (canales.isEmpty()) {
            throw new RuntimeException("El usuario no tiene un canal");
        }
    
        // Seleccionar el primer canal disponible (si hay más de uno, puedes agregar lógica adicional)
        Canal canal = canales.get(0);
    
        // Crear el contenido
        Contenido contenido = new Contenido();
        contenido.setTitulo(titulo); // Asigna el título
        contenido.setDescripcion(descripcion); // Asigna la descripción
        contenido.setCategoria(categoria); // Asigna la categoría
        contenido.setTipoVideo(tipoContenido); // Asigna el tipo de video
        contenido.setDuracion(duracion); // Asigna la duración
        contenido.setTags(new ArrayList<>(etiquetas)); // Convierte etiquetas en ArrayList si es necesario
        contenido.setFechaPublicacion(LocalDate.now()); // Establece solo la fecha actual (sin la hora)
        contenido.setCanal(canal); // Asocia el contenido con el canal del usuario
        contenido.setMiniatura(miniatura); // Agrega la miniatura (imagen del video)
    
        // Guardar el contenido en la base de datos
        return contenidoRepository.save(contenido);
    }
    


    
    @Override
    public void eliminarContenido(Users user, Long contenidoId) {
        // Verificar si el contenido existe
        Contenido contenido = contenidoRepository.findById(contenidoId)
            .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));

        // Verificar si el contenido pertenece al canal del usuario
        if (!contenido.getCanal().getUser().equals(user)) {
            throw new RuntimeException("No tienes permiso para eliminar este contenido");
        }

        // Eliminar el contenido
        contenidoRepository.delete(contenido);
    }



    @Override
    public Contenido editarContenido(Users user, Long contenidoId, String nuevoTitulo, String nuevaDescripcion, String nuevaCategoria, String nuevoTipoContenido, int nuevaDuracion, List<String> nuevasEtiquetas) {
    // Verificar si el contenido existe
    Contenido contenido = contenidoRepository.findById(contenidoId)
        .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));

    // Verificar si el contenido pertenece al canal del usuario
    if (!contenido.getCanal().getUser().equals(user)) {
        throw new RuntimeException("No tienes permiso para editar este contenido");
    }

    // Editar los atributos del contenido
    contenido.setTitulo(nuevoTitulo != null ? nuevoTitulo : contenido.getTitulo());
    contenido.setDescripcion(nuevaDescripcion != null ? nuevaDescripcion : contenido.getDescripcion());
    contenido.setCategoria(nuevaCategoria != null ? nuevaCategoria : contenido.getCategoria());
    contenido.setTipoVideo(nuevoTipoContenido != null ? nuevoTipoContenido : contenido.getTipoVideo());
    contenido.setDuracion(nuevaDuracion >= 0 ? nuevaDuracion : contenido.getDuracion());  // Asegurar que la duración sea válida
    contenido.setTags(nuevasEtiquetas != null && !nuevasEtiquetas.isEmpty() ? nuevasEtiquetas : contenido.getTags());  // Asignar la lista de etiquetas

    // Guardar el contenido actualizado
    return contenidoRepository.save(contenido);
}


}
