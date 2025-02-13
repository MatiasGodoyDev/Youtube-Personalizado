package ar.edu.centro8.td1.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Canal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_canal")
    private String nombreCanal;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String tipoCanal;
    private String imagenPerfil;
    private String imagenPortada;
    
    @OneToMany(mappedBy = "canal")
    private List<Seguimiento> suscriptores;  // Relación con los seguidores (lista de Seguimiento)
    @Column(name = "suscriptores_conteo", nullable = false)
private int suscriptoresConteo = 0; // Asigna un valor por defecto en la entidad

    
    private String urlCanal;
    private String categoria;
    private String nuevoNombre;

    @OneToOne
    @JoinColumn(name = "user_id")  // Relación con el propietario del canal (User)
    private Users user;

    @OneToMany(mappedBy = "canal") // Relación con Contenido (Uno a Muchos)
    private List<Contenido> contenidos;

    
    // Constructor
    public Canal() {
        this.suscriptoresConteo = 0;  // Inicializar el contador de suscriptores
        this.suscriptores = new ArrayList<>();  // Inicializar la lista de suscriptores
    }

   // Método para agregar un suscriptor
public void agregarSuscriptor(Seguimiento seguimiento) {
    if (this.suscriptores == null) {
        this.suscriptores = new ArrayList<>();
    }
    this.suscriptores.add(seguimiento);  // Añadir el suscriptor a la lista
    this.suscriptoresConteo++;  // Incrementar el contador de suscriptores
}

// Método para eliminar un suscriptor
public void eliminarSuscriptor(Seguimiento seguimiento) {
    if (this.suscriptores != null) {
        this.suscriptores.remove(seguimiento);  // Eliminar el suscriptor de la lista
        this.suscriptoresConteo--;  // Disminuir el contador de suscriptores
    }
}


    // Getters y Setters generados por Lombok
    // Aquí van todos los getters y setters generados automáticamente por la anotación @Getter y @Setter de Lombok.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoCanal() {
        return tipoCanal;
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

    public List<Seguimiento> getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(List<Seguimiento> suscriptores) {
        this.suscriptores = suscriptores;
    }

    public int getSuscriptoresConteo() {
        return suscriptores.size();
    }

    public void setSuscriptoresConteo(int suscriptoresConteo) {
        this.suscriptoresConteo = suscriptoresConteo;
    }

    public String getUrlCanal() {
        return urlCanal;
    }

    public void setUrlCanal(String urlCanal) {
        this.urlCanal = urlCanal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
}
