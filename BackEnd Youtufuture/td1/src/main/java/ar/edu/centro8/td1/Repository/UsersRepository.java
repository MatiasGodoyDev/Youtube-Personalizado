package ar.edu.centro8.td1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.centro8.td1.Enum.Roles;
import ar.edu.centro8.td1.Enum.TipoUser;
import ar.edu.centro8.td1.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsersName(String usersName);
    boolean existsByEmail(String email);
    Optional<Users> findByEmailOrUsersName(String email, String usersName);
    
    // Métodos para filtrar usuarios por tipo de usuario (TipoUser)
    List<Users> findByTipoUser(TipoUser tipoUser);
    
    // Métodos para filtrar usuarios por rol (Roles)
    List<Users> findByRoles(Roles roles);
}
