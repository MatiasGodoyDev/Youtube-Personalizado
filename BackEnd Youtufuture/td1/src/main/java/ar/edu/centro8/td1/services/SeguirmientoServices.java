package ar.edu.centro8.td1.services;

import java.util.List;

import ar.edu.centro8.td1.model.Canal;
import ar.edu.centro8.td1.model.Seguimiento;
import ar.edu.centro8.td1.model.Users;

public interface SeguirmientoServices {
    Seguimiento follow(Users user, String nombreCanal);
    void unfollow(Users user, String nombreCanal);  // Define el método en la interfaz
    List<Canal> ObtenerCanalesSeguidos(Users user);
    // Agregar el nuevo método para obtener canales por nombre
    List<Canal> ObtenerCanalesPorNombre(String nombreCanal);

    
}
