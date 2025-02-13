package ar.edu.centro8.td1.services.Implements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.centro8.td1.Repository.SeguimientoRepository;
import ar.edu.centro8.td1.Repository.CanalRepository; // Asegúrate de tener este repositorio
import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Seguimiento;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.SeguirmientoServices;

@Service
public class ImplementacionServicioSeguimiento implements SeguirmientoServices {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    @Autowired
    private CanalRepository canalRepository; // Nuevo repositorio para Canal

    @Override
    public List<Canal> ObtenerCanalesPorNombre(String nombreCanal) {
    return canalRepository.findByNombreCanalContainingIgnoreCase(nombreCanal);  // Llamada al repositorio CanalRepository
}


    @Override
    public Seguimiento follow(Users user, String nombreCanal) {
        // Buscar el canal por nombreCanal
        Canal canal = canalRepository.findByNombreCanal(nombreCanal)
            .orElseThrow(() -> new RuntimeException("Canal no encontrado"));

        // Lógica para seguir un canal
        if (seguimientoRepository.existsByUserAndCanal(user, canal)) {
            throw new RuntimeException("Ya sigues este canal");
        }

        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setUser(user);  // Usamos el usuario que ya pasaste (cambiado de 'setUsuario' a 'setUser')
        seguimiento.setCanal(canal);
        seguimiento.setFechaSeguimiento(LocalDateTime.now()); // Fecha del seguimiento
        canal.agregarSuscriptor(seguimiento); // Agregar suscriptor al canal

        return seguimientoRepository.save(seguimiento);
    }

    @Override
    public void unfollow(Users user, String nombreCanal) {
        // Buscar el canal por nombreCanal
        Canal canal = canalRepository.findByNombreCanal(nombreCanal)
            .orElseThrow(() -> new RuntimeException("Canal no encontrado"));

        // Buscar y eliminar el seguimiento
        Seguimiento seguimiento = seguimientoRepository.findByUserAndCanal(user, canal)
            .orElseThrow(() -> new RuntimeException("No sigues este canal"));

        canal.eliminarSuscriptor(seguimiento);  // Eliminar suscriptor del canal
        seguimientoRepository.delete(seguimiento);
    }

    @Override
    public List<Canal> ObtenerCanalesSeguidos(Users user) {
        // Obtener la lista de seguimientos del usuario
        List<Seguimiento> seguimientos = seguimientoRepository.findByUser(user);

        // Convertir la lista de seguimientos a una lista de canales
        List<Canal> canalesSeguidos = new ArrayList<>();
        for (Seguimiento seguimiento : seguimientos) {
            canalesSeguidos.add(seguimiento.getCanal());
        }
        return canalesSeguidos;
    }
}
