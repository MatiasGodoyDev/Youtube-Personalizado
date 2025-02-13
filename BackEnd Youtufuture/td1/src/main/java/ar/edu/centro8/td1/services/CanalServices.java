package ar.edu.centro8.td1.services;

import ar.edu.centro8.td1.model.Canal;

public interface CanalServices {
    
    Canal obtenerCanal (String obtenerCanal);

    Canal editCanal(String nombreCanal,String nuevoNombre, String descripcion, String tipoCanal, String imagenPerfil, String imagenPortada, String urlCanal, String categoria);


     Canal crearCanal(String emailOrUsersName, String nombreCanal, String descripcion, String imagenPerfil, String imagenPortada, String urlCanal);
}
