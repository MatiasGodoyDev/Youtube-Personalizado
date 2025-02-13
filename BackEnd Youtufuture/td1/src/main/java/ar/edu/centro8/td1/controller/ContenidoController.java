package ar.edu.centro8.td1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.centro8.td1.DTOs.ContenidoRequest;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.ContenidoServices;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoServices contenidoServices;

    // Subir contenido (POST)
    @PostMapping("/subir")
    public ResponseEntity<Contenido> subirContenido(
            @RequestBody ContenidoRequest contenidoRequest,
            @RequestAttribute("user") Users user
    ) {
        try {
            Contenido contenido = contenidoServices.subirContenido(
                    user,
                    contenidoRequest.getTitulo(),
                    contenidoRequest.getDescripcion(),
                    contenidoRequest.getCategoria(),
                    contenidoRequest.getTipoContenido(),
                    contenidoRequest.getDuracion(),
                    contenidoRequest.getEtiquetas(),
                    contenidoRequest.getMiniatura() // Nuevo parámetro para la miniatura
            );
            return ResponseEntity.ok(contenido);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Editar contenido (PUT)
    @PutMapping("/editar/{contenidoId}")
    public ResponseEntity<Contenido> editarContenido(
            @PathVariable Long contenidoId,
            @RequestBody ContenidoRequest contenidoRequest,
            @RequestAttribute("user") Users user
    ) {
        try {
            Contenido contenido = contenidoServices.editarContenido(
                    user,
                    contenidoId,
                    contenidoRequest.getNuevoTitulo(),
                    contenidoRequest.getNuevaDescripcion(),
                    contenidoRequest.getNuevaCategoria(),
                    contenidoRequest.getNuevoTipoContenido(),
                    contenidoRequest.getNuevaDuracion(),
                    contenidoRequest.getNuevasEtiquetas()
            );
            return ResponseEntity.ok(contenido);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Eliminar contenido (DELETE)
    @DeleteMapping("/eliminar/{contenidoId}")
    public ResponseEntity<String> eliminarContenido(
            @PathVariable Long contenidoId,
            @RequestAttribute("user") Users user
    ) {
        try {
            contenidoServices.eliminarContenido(user, contenidoId);
            return ResponseEntity.ok("Contenido eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("No tienes permiso para eliminar este contenido");
        }
    }
}
