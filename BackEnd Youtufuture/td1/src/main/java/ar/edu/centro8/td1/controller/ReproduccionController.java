package ar.edu.centro8.td1.controller;

import ar.edu.centro8.td1.model.Reproduccion;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.DTOs.IniciarReproduccionRequest;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.services.ReproduccionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reproducciones")
public class ReproduccionController {

    @Autowired
    private ReproduccionServices reproduccionServices;

    // Iniciar una nueva reproducción
    @PostMapping("/iniciar")
    public ResponseEntity<Reproduccion> iniciarReproduccion(@RequestBody IniciarReproduccionRequest request) {
        Reproduccion reproduccion = reproduccionServices.iniciarReproduccion(
                request.getUsuario(), request.getContenido(), request.getDispositivo(),
                request.getTipoReproduccion(), request.getCalidad()
        );
        return ResponseEntity.ok(reproduccion);
    }

    // Pausar una reproducción
    @PostMapping("/pausar/{id}")
    public ResponseEntity<Reproduccion> pausarReproduccion(@PathVariable Long id) {
        Reproduccion reproduccion = reproduccionServices.pausarReproduccion(id);
        if (reproduccion != null) {
            return ResponseEntity.ok(reproduccion);
        }
        return ResponseEntity.notFound().build();
    }

    // Reanudar una reproducción
    @PostMapping("/reanudar/{id}")
    public ResponseEntity<Reproduccion> reanudarReproduccion(@PathVariable Long id, @RequestParam int tiempoReanudacion) {
        Reproduccion reproduccion = reproduccionServices.reanudarReproduccion(id, tiempoReanudacion);
        if (reproduccion != null) {
            return ResponseEntity.ok(reproduccion);
        }
        return ResponseEntity.notFound().build();
    }

    // Finalizar una reproducción
    @PostMapping("/finalizar/{id}")
    public ResponseEntity<Reproduccion> finalizarReproduccion(@PathVariable Long id, @RequestParam float porcentajeCompletado) {
        Reproduccion reproduccion = reproduccionServices.finalizarReproduccion(id, porcentajeCompletado);
        if (reproduccion != null) {
            return ResponseEntity.ok(reproduccion);
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener todas las reproducciones de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reproduccion>> obtenerReproduccionesPorUsuario(@PathVariable Long usuarioId) {
        // Aquí se debería obtener el usuario por su ID
        Users usuario = new Users();
        usuario.setId(usuarioId);  // Este es solo un ejemplo, debes obtener el usuario desde la base de datos
        List<Reproduccion> reproducciones = reproduccionServices.obtenerReproduccionesPorUsuario(usuario);
        return ResponseEntity.ok(reproducciones);
    }

    // Obtener una reproducción específica
    @GetMapping("/{id}")
    public ResponseEntity<Reproduccion> obtenerReproduccionPorId(@PathVariable Long id) {
        Optional<Reproduccion> reproduccion = reproduccionServices.obtenerReproduccionPorId(id);
        return reproduccion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
