package ar.edu.centro8.td1.services;

import java.time.LocalDate;
import java.util.Optional;

import ar.edu.centro8.td1.Enum.Roles;
import ar.edu.centro8.td1.Enum.TipoUser;
import ar.edu.centro8.td1.model.Users;

public interface UserServices {
    // Buscar por email
    Optional<Users> findByEmail(String email);

    // Buscar por email o username
    Optional<Users> findByEmailOrUsersName(String email, String usersName);

    // Buscar por username
    Optional<Users> findByUsersName(String usersName);

    // Fijarse si el email ya existe
    boolean existsByEmail(String email);

    // Autentificar el usuario
    boolean authenticateUser(String usersName, String contraseña);
    //  registro
    Users registrarUser(String nombre, String apellido, String email, String contraseña, TipoUser tipoUser, Roles roles, String usersName, LocalDate fechaNacimiento);

    // Eliminación
    void eliminarUser(String emailOrUsersName, String contraseña);

    // Edición
    Users editUsers(String nombre, String apellido, String contraseña, String repetirContraseña, String nuevaContraseña, TipoUser tipoUser, Roles roles, String usersName, String telefono, String email);

    // Login
    Users loginUser(String emailOrUsersName, String contraseña);
}
