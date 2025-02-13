package ar.edu.centro8.td1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.centro8.td1.DTOs.DeleteRequest;
import ar.edu.centro8.td1.DTOs.EditUserRequest;
import ar.edu.centro8.td1.DTOs.LoginRequest;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.services.UserServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/user")
public class UsersController {

    private final UserServices userServices;

    @Autowired
    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users newUser) {
        try {
            Users registeredUser = userServices.registrarUser(
                newUser.getNombre(),
                newUser.getApellido(),
                newUser.getEmail(),
                newUser.getContraseña(),
                newUser.getTipoUser(),
                newUser.getRoles(),
                newUser.getUsersName(),
                newUser.getfechaNacimiento()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editUser(@Valid @RequestBody EditUserRequest editRequest) {
        try {
            // Verificar las credenciales del usuario
            boolean isAuthenticated = userServices.authenticateUser(editRequest.getUsersName(), editRequest.getContraseña());

            if (!isAuthenticated) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                     .body("Credenciales incorrectas. Acceso denegado.");
            }

            // Buscar al usuario por su nombre de usuario o email
            Users user = userServices.findByUsersName(editRequest.getUsersName())
                                     .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Proceder con la edición del usuario
            Users updatedUser = userServices.editUsers(
                editRequest.getNombre(),
                editRequest.getApellido(),
                editRequest.getContraseña(),
                editRequest.getRepetirContraseña(), 
                editRequest.getNuevaContraseña(),
                editRequest.getTipoUser(),
                editRequest.getRoles(),
                editRequest.getUsersName(),
                editRequest.getTelefono(),
                editRequest.getEmail()
            );

            // Devolver el usuario actualizado
            return ResponseEntity.ok(updatedUser);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(e.getMessage()); // Mensaje claro del error de negocio
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error interno del servidor");
        }
    }


    // Controlador de Login
     @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
    try {
        Users user = userServices.loginUser(loginRequest.getEmailOrUsersName(), loginRequest.getContraseña());
        return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
    }
}


    @DeleteMapping("/delete")
    public ResponseEntity<String> eliminarUser(@RequestBody DeleteRequest request) {
    try {
        // Llamamos al servicio para eliminar el usuario proporcionando solo email/username y contraseña
        userServices.eliminarUser(request.getEmailOrUsersName(), request.getContraseña());
        return ResponseEntity.ok("Usuario eliminado con éxito");
    } catch (IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    } catch (EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    } catch (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
    }
}


}
