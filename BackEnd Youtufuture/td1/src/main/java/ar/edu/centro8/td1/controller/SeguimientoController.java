    package ar.edu.centro8.td1.controller;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

import ar.edu.centro8.td1.DTOs.FollowRequest;
import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.CanalServices;
import ar.edu.centro8.td1.services.SeguirmientoServices;

    @RestController
    @RequestMapping("/seguimiento")
    public class SeguimientoController {

        @Autowired
        private SeguirmientoServices seguirmientoServices;
        @Autowired
        private CanalServices canalServices;

    // Endpoint para seguir un canal
    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestBody FollowRequest followRequest) {
        try {
            // Aquí estamos usando el nombreCanal en lugar del id
            Users user = followRequest.getUser();
            String nombreCanal = followRequest.getNombreCanal();
            seguirmientoServices.follow(user, nombreCanal);  // Llamamos al servicio para seguir el canal
            return ResponseEntity.ok("Has seguido el canal exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Endpoint para dejar de seguir un canal
    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollow(@RequestBody FollowRequest followRequest) {
        try {
            // Aquí estamos usando el nombreCanal en lugar del id
            Users user = followRequest.getUser();
            String nombreCanal = followRequest.getNombreCanal();
            seguirmientoServices.unfollow(user, nombreCanal);  // Llamamos al servicio para dejar de seguir el canal
            return ResponseEntity.ok("Has dejado de seguir el canal.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


        @GetMapping("/canalesSeguidos")
        public ResponseEntity<List<Canal>> obtenerCanalesPorNombre(@RequestParam String nombreCanal) {
            try {
                // Llamada al servicio que buscará los canales por nombre
                List<Canal> canales = seguirmientoServices.ObtenerCanalesPorNombre(nombreCanal);

                if (canales.isEmpty()) {
                    return ResponseEntity.noContent().build();  // Si no hay canales, responde sin contenido
                }

                return ResponseEntity.ok(canales);  // Retorna los canales encontrados
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(null);  // En caso de error
            }
        }

    }
