package ar.edu.centro8.td1.DTOs;

import ar.edu.centro8.td1.Enum.Roles;
import ar.edu.centro8.td1.Enum.TipoUser;

public class EditUserRequest {

    private String usersName;
    private String contraseña;
    private String repetirContraseña;
    private String nombre;
    private String apellido;
    private TipoUser tipoUser;
    private Roles roles;
    private String telefono;
    private String nuevaContraseña;
    private String email;

    // Getters y setters

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRepetirContraseña() {
        return repetirContraseña;
    }

    public void setRepetirContraseña(String repetirContraseña) {
        this.repetirContraseña = repetirContraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoUser getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUser tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNuevaContraseña() {
        return nuevaContraseña;
    }

    public void setNuevaContraseña(String nuevaContraseña) {
        this.nuevaContraseña = nuevaContraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
