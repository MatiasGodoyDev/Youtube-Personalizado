package ar.edu.centro8.td1.services.Implements;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.centro8.td1.Repository.UsersRepository;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.Enum.Roles;
import ar.edu.centro8.td1.Enum.TipoUser;
import ar.edu.centro8.td1.services.UserServices;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ImplementacionServicioUsuario implements UserServices {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ImplementacionServicioUsuario(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Registro de usuario
    @Override
    public Users registrarUser(String nombre, String apellido, String email, String contraseña, TipoUser tipoUser, Roles roles, String usersName, LocalDate fechaNacimiento) {
        // Verificar si el email ya está registrado
        if (usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Ya existe un email registrado");
        }

        // Verificar si el nombre de usuario ya está registrado
        if (usersRepository.findByUsersName(usersName).isPresent()) {
            throw new RuntimeException("Ya existe un usuario registrado con ese nombre");
        }

        // Cifrar la contraseña antes de guardarla
        String contraseñaCifrada = passwordEncoder.encode(contraseña);

        // Crear un nuevo objeto de tipo Users
        Users user = new Users();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setEmail(email);
        user.setContraseña(contraseñaCifrada);
        user.setTipoUser(tipoUser);  // Se asigna el tipo de usuario desde el enum
        user.setRoles(roles);  // Se asigna el rol desde el enum
        user.setUsersName(usersName);
        user.setfechaNacimiento(fechaNacimiento); // Establecer la fecha de nacimiento

        // Guardar el usuario usando el repositorio
        return usersRepository.save(user);
    }

    // Editar Usuario
    @Override
    public Users editUsers(String nombre, String apellido, String contraseña, String repetirContraseña, String nuevaContraseña, TipoUser tipoUser, Roles roles, String usersName, String telefono, String email) {
        // Verificar si las contraseñas coinciden
        if (!contraseña.equals(repetirContraseña)) {
            throw new RuntimeException("Las contraseñas no coinciden");
        }

        // Buscar al usuario por email o nombre de usuario y contraseña
        Users user = usersRepository.findByEmailOrUsersName(email, usersName)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar que la contraseña actual coincida
        if (!passwordEncoder.matches(contraseña, user.getContraseña())) {
            throw new RuntimeException("La contraseña actual es incorrecta");
        }

        // Verificar si el nombre de usuario ya está en uso por otro usuario
        Optional<Users> existingUser = usersRepository.findByUsersName(usersName);
        if (existingUser.isPresent() && existingUser.get().getId() != user.getId()) {
            throw new RuntimeException("Ya existe un usuario con ese nombre");
        }

        // Actualizar los datos del usuario
        user.setNombre(nombre);
        user.setApellido(apellido);

        // Si se proporciona una nueva contraseña, actualizarla
        if (nuevaContraseña != null && !nuevaContraseña.isEmpty()) {
            user.setContraseña(passwordEncoder.encode(nuevaContraseña));  // Cifrar la nueva contraseña
        }

        // Actualizar otros detalles del usuario
        user.setTipoUser(tipoUser);  // Se actualiza el tipo de usuario con el enum
        user.setRoles(roles);  // Se actualiza el rol con el enum
        user.setUsersName(usersName);
        user.setTelefono(telefono);
        user.setEmail(email);

        // Guardar los cambios en el usuario
        return usersRepository.save(user);
    }

    @Override
    public boolean authenticateUser(String emailOrUsersName, String contraseña) {
        // Buscar el usuario por email o nombre de usuario
        Optional<Users> userOptional = usersRepository.findByEmailOrUsersName(emailOrUsersName, emailOrUsersName);
        
        // Si no se encuentra el usuario, devolver falso
        if (userOptional.isEmpty()) {
            return false; // El usuario no existe
        }

        Users user = userOptional.get();
        
        // Comparar la contraseña ingresada con la contraseña cifrada almacenada
        return passwordEncoder.matches(contraseña, user.getContraseña());
    }

    @Override
    public Users loginUser(String emailOrUsersName, String contraseña) {
        Optional<Users> userOptional = usersRepository.findByEmailOrUsersName(emailOrUsersName, emailOrUsersName);
        
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Users user = userOptional.get();
        
        // Verificar si la contraseña coincide
        if (!passwordEncoder.matches(contraseña, user.getContraseña())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        
        return user;
    }

    @Override
    public void eliminarUser(String emailOrUsersName, String contraseña) {
        // Buscar al usuario por email o username
        Optional<Users> userOptional = usersRepository.findByEmailOrUsersName(emailOrUsersName, emailOrUsersName);
        
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }

        Users user = userOptional.get();
        
        // Verificar si la contraseña proporcionada coincide con la almacenada (suponiendo que usas un password encoder)
        if (!passwordEncoder.matches(contraseña, user.getContraseña())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // Eliminar el usuario
        usersRepository.delete(user);
    }

    @Override
    public Optional<Users> findByUsersName(String userName) {
        return usersRepository.findByUsersName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> findByEmailOrUsersName(String email, String usersName) {
        // Buscar al usuario por email o por nombre de usuario
        Optional<Users> user = usersRepository.findByEmail(email);
        if (user.isEmpty()) {
            user = usersRepository.findByUsersName(usersName);
        }
        return user;
    }
}
