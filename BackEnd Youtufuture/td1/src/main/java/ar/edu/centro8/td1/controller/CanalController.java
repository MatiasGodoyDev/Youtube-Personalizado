package ar.edu.centro8.td1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
    
import ar.edu.centro8.td1.DTOs.CanalRequest;
import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.services.CanalServices;

@RestController
@RequestMapping("/canal")
public class CanalController {

    @Autowired
    private CanalServices canalServices;

   // Crear un canal
@PostMapping("/register")
public ResponseEntity<?> crearCanal(@RequestBody CanalRequest canalRequest) {
    // Validación de campos obligatorios
    if (canalRequest.getEmailOrUsersName() == null || canalRequest.getEmailOrUsersName().isEmpty()) {
        return new ResponseEntity<>("El email o nombre de usuario es requerido", HttpStatus.BAD_REQUEST);
    }
    if (canalRequest.getNombreCanal() == null || canalRequest.getNombreCanal().isEmpty()) {
        return new ResponseEntity<>("El nombre del canal es requerido", HttpStatus.BAD_REQUEST);
    }

    try {
        // Llamamos al servicio para crear el canal usando los datos recibidos en el JSON
        Canal nuevoCanal = canalServices.crearCanal(
            canalRequest.getEmailOrUsersName(),
            canalRequest.getNombreCanal(),
            canalRequest.getDescripcion(),
            canalRequest.getImagenPerfil(),
            canalRequest.getImagenPortada(),
            canalRequest.getUrlCanal()
        );
        return new ResponseEntity<>(nuevoCanal, HttpStatus.CREATED); // Retornamos el canal creado con un status 201
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>("Datos inválidos: " + e.getMessage(), HttpStatus.BAD_REQUEST); // Error con los datos proporcionados
    } catch (Exception e) {
        // Capturamos cualquier otro tipo de excepción
        return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR); // Error inesperado
    }
}


    
        @PutMapping("/edit")
        public ResponseEntity<Canal> editarCanal(@RequestBody CanalRequest canalRequest) {
            try {
                // Llamar al servicio para editar el canal
                Canal canalActualizado = canalServices.editCanal(
                    canalRequest.getNombreCanal(),
                    canalRequest.getNuevoNombre(),
                    canalRequest.getDescripcion(),
                    canalRequest.getTipoCanal(),
                    canalRequest.getImagenPerfil(),
                    canalRequest.getImagenPortada(),
                    canalRequest.getUrlCanal(),
                    canalRequest.getCategoria()
                );
    
                return new ResponseEntity<>(canalActualizado, HttpStatus.OK);
            } catch (RuntimeException e) {
                // Manejar errores y devolver un mensaje amigable
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null); // Puedes devolver un mensaje en lugar de `null` si es necesario.
            }
        }
    }
    



