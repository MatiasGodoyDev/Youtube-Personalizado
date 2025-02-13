package ar.edu.centro8.td1.DTOs;

public class CanalRequest {
    private String nombreCanal; // Nombre del canal
    private String nuevoNombre; // Para actualizar nombre
    private String descripcion; // Descripción del canal
    private String tipoCanal;
    private String imagenPerfil; // Imagen de perfil
    private String imagenPortada; // Imagen de portada
    private String urlCanal; // URL del canal
    private String email; // Email para eliminar el canal
    private String contraseña; // Contraseña para eliminar el canal
    private String emailOrUsersName; // Corregido el nombre de esta variable
    private String categoria;

    // Getters y setters
    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public String getEmailOrUsersName() { // Corregido el nombre del getter
        return emailOrUsersName;
    }

    public void setEmailOrUsersName(String emailOrUsersName) { // Corregido el nombre del setter
        this.emailOrUsersName = emailOrUsersName;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCanal() {
        return this.tipoCanal;
    }

    public void setTipoCanal(String tipoCanal) {
        this.tipoCanal = tipoCanal;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public String getUrlCanal() {
        return urlCanal;
    }

    public void setUrlCanal(String urlCanal) {
        this.urlCanal = urlCanal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
