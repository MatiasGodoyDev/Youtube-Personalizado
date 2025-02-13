package ar.edu.centro8.td1.services.Implements;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.centro8.td1.Repository.CanalRepository;
import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.CanalServices;
import ar.edu.centro8.td1.services.UserServices;
@Service
public class ImplementacionServicioCanal implements CanalServices{

     @Autowired
    private CanalRepository canalRepository;
    @Autowired
    private UserServices userService;

    @Override
    public Canal crearCanal(String emailOrUsersName, String nombreCanal, String descripcion, String imagenPerfil, String imagenPortada, String urlCanal) {
        // Validar si ya existe un canal con el mismo nombre
        if (canalRepository.existsByNombreCanal(nombreCanal)) {
            throw new IllegalArgumentException("Ya existe un canal con el nombre: " + nombreCanal);
        }

        // Buscar al usuario por email o username
        Optional<Users> userOptional = userService.findByEmailOrUsersName(emailOrUsersName, emailOrUsersName);  // Usar userService para llamar al método
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        Users user = userOptional.get();

        // Crear el canal
        Canal nuevoCanal = new Canal();
        
        nuevoCanal.setSuscriptoresConteo(0); // Valor inicial de suscriptores
        nuevoCanal.setNombreCanal(nombreCanal);
        nuevoCanal.setDescripcion(descripcion != null ? descripcion : ""); // Descripción opcional
        nuevoCanal.setImagenPerfil(imagenPerfil != null ? imagenPerfil : "default-profile.png"); // Valor por defecto
        nuevoCanal.setImagenPortada(imagenPortada != null ? imagenPortada : "default-banner.png"); // Valor por defecto
        nuevoCanal.setUrlCanal(urlCanal);
        nuevoCanal.setFechaCreacion(LocalDateTime.now()); // Establecer la fecha actual
        nuevoCanal.setUser(user); // Asocia el canal con el usuario encontrado


        // Guardar el canal en la base de datos
        return canalRepository.save(nuevoCanal);
    }



    @Override
public Canal editCanal(String nombreCanal, String nuevoNombre, String descripcion, String tipoCanal, String imagenPerfil, String imagenPortada, String urlCanal, String categoria) {
    // Buscar el canal existente por su nombre actual
    Canal canalExistente = canalRepository.findByNombreCanal(nombreCanal)
        .orElseThrow(() -> new RuntimeException("El canal con el nombre " + nombreCanal + " no existe."));

    // Verificar si el nuevo nombre ya está en uso por otro canal
    if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
        Optional<Canal> canalConNuevoNombre = canalRepository.findByNombreCanal(nuevoNombre);
        if (canalConNuevoNombre.isPresent() && canalConNuevoNombre.get().getId() != canalExistente.getId()) {
            throw new RuntimeException("El nombre del canal '" + nuevoNombre + "' ya está en uso.");
        }
        canalExistente.setNombreCanal(nuevoNombre); // Actualizar el nombre del canal
    }

    // Actualizar los demás atributos solo si se proporcionan nuevos valores
    if (descripcion != null && !descripcion.isEmpty()) {
        canalExistente.setDescripcion(descripcion);
    }

    if (tipoCanal != null && !tipoCanal.isEmpty()) {
        canalExistente.setTipoCanal(tipoCanal);
    }

    if (imagenPerfil != null && !imagenPerfil.isEmpty()) {
        canalExistente.setImagenPerfil(imagenPerfil);
    }

    if (imagenPortada != null && !imagenPortada.isEmpty()) {
        canalExistente.setImagenPortada(imagenPortada);
    }

    if (urlCanal != null && !urlCanal.isEmpty()) {
        canalExistente.setUrlCanal(urlCanal);
    }

    if (categoria != null && !categoria.isEmpty()) {
        canalExistente.setCategoria(categoria);
    }

    // Guardar los cambios en la base de datos
    return canalRepository.save(canalExistente);
}







  // Obtener el canal por nombre 
  @Override
  public Canal obtenerCanal(String nombreCanal) {
      return canalRepository.findByNombreCanal(nombreCanal)
              .orElseThrow(() -> new IllegalArgumentException("Canal no encontrado con el nombre: " + nombreCanal));
  }


}
