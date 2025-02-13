package ar.edu.centro8.td1.controller;

import ar.edu.centro8.td1.model.Interaccion;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.Enum.EstadoInteraccion;
import ar.edu.centro8.td1.Enum.TipoInteraccion;
import ar.edu.centro8.td1.services.InteraccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interacciones")
public class InteraccionController {

    @Autowired
    private InteraccionServices interaccionServices;

    // Crear una nueva interacción
    @PostMapping("/crear")
    public ResponseEntity<Interaccion> crearInteraccion(@RequestParam Long usuarioId, 
                                                        @RequestParam Long contenidoId, 
                                                        @RequestParam TipoInteraccion tipoInteraccion, 
                                                        @RequestParam(required = false) String comentario,
                                                        @RequestParam boolean like, 
                                                        @RequestParam boolean notlike, 
                                                        @RequestParam boolean compartido, 
                                                        @RequestParam float rating, 
                                                        @RequestParam List<String> etiquetas,
                                                        @RequestParam(required = false) String reacciones, 
                                                        @RequestParam(required = false) String origen, 
                                                        @RequestParam(required = false) String urlMultimedia) {
        // Suponiendo que tienes un método para buscar Usuario y Contenido por ID
        Users usuario = new Users(); // Aquí deberías obtener el usuario por su ID
        Contenido contenido = new Contenido(); // Aquí deberías obtener el contenido por su ID
        
        // Crear la interacción usando el servicio
        Interaccion interaccion = interaccionServices.crearInteraccion(usuario, contenido, tipoInteraccion, comentario, like, notlike, compartido, rating, etiquetas, reacciones, origen, urlMultimedia);
        
        return new ResponseEntity<>(interaccion, HttpStatus.CREATED);
    }

    // Obtener todas las interacciones de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Interaccion>> obtenerInteraccionesPorUsuario(@PathVariable Long usuarioId) {
        // Suponiendo que tienes un método para obtener el usuario por su ID
        Users usuario = new Users(); // Aquí deberías obtener el usuario por su ID
        List<Interaccion> interacciones = interaccionServices.obtenerInteraccionesPorUsuario(usuario);
        return new ResponseEntity<>(interacciones, HttpStatus.OK);
    }

    // Obtener todas las interacciones de un contenido
    @GetMapping("/contenido/{contenidoId}")
    public ResponseEntity<List<Interaccion>> obtenerInteraccionesPorContenido(@PathVariable Long contenidoId) {
        // Suponiendo que tienes un método para obtener el contenido por su ID
        Contenido contenido = new Contenido(); // Aquí deberías obtener el contenido por su ID
        List<Interaccion> interacciones = interaccionServices.obtenerInteraccionesPorContenido(contenido);
        return new ResponseEntity<>(interacciones, HttpStatus.OK);
    }

    // Obtener una interacción por ID
    @GetMapping("/{interaccionId}")
    public ResponseEntity<Interaccion> obtenerInteraccionPorId(@PathVariable Long interaccionId) {
        Optional<Interaccion> interaccionOpt = interaccionServices.obtenerInteraccionPorId(interaccionId);
        return interaccionOpt.map(interaccion -> new ResponseEntity<>(interaccion, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar el estado de una interacción
    @PutMapping("/{interaccionId}/estado")
    public ResponseEntity<Interaccion> actualizarEstadoInteraccion(@PathVariable Long interaccionId, 
                                                                  @RequestParam EstadoInteraccion nuevoEstado) {
        Interaccion interaccion = interaccionServices.actualizarEstadoInteraccion(interaccionId, nuevoEstado);
        return interaccion != null ? new ResponseEntity<>(interaccion, HttpStatus.OK) 
                                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar interacción
    @DeleteMapping("/{interaccionId}")
    public ResponseEntity<Void> eliminarInteraccion(@PathVariable Long interaccionId) {
        interaccionServices.eliminarInteraccion(interaccionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
