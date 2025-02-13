package ar.edu.centro8.td1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ar.edu.centro8.td1.Enum.Roles;
import ar.edu.centro8.td1.Enum.TipoUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    //@NotEmpty (message = "El apellido no puede estar vacio")
    private String apellido;
    //@Email(message = "El email tiene que ser una email valido")
    //@NotEmpty (message = "El email no puede estar vacio")
    private String email;
    //@NotEmpty  (message = "La contraseña no puede estar vacia")
    private String contraseña;
    //@NotEmpty (message = "La contraseña no puede estar vacia")
    private String repetirContraseña;
    private String nuevaContraseña;
    @Enumerated(EnumType.STRING)
    private TipoUser tipoUser;
    //@NotEmpty (message = "El Nombre de usuario no puede estar vacio")
    private String usersName;
    private LocalDate fechaNacimiento;
    private String sexo;
    private LocalDateTime ultimoLogin;
    // private String  estado;
    private String preferencias;
    //@NotEmpty (message = "El telefono no puede estar vacio")
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Canal> canales;
    @OneToMany(mappedBy = "usuario")  // Relación con Reproducción (Uno a Muchos)
    private List<Reproduccion> reproducciones;
    @OneToMany
    private List<MetodosDePago> metodosDePagos;

    public Users() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUser getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUser tipoUser) {
        this.tipoUser = tipoUser;
    }

    public LocalDate getfechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setfechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getUltimoLogin() {
        return this.ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    // public String getEstado() {
    //     return this.estado;
    // }
    // public void setEstado(String estado) {
    //     this.estado = estado;
    // }
    public String getPreferencias() {
        return this.preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersName() {
        return this.usersName;
    }

    public void setnuevaContraseña(String nuevaContraseña) {
        this.nuevaContraseña = nuevaContraseña;
    }

    public String getnuevaContraseña() {
        return this.nuevaContraseña;
    }

}
