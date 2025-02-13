package ar.edu.centro8.td1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contenido {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "canal_id", referencedColumnName = "id")
    private Canal canal;
    private String titulo;
    private String descripcion;
    private String categoria;
    private LocalDate fechaPublicacion;
    private int duracion;
    private List<String> tags;
    private String tipoVideo;
    private String miniatura;

    // futbol
    private String estadio;
    private String resultado; // El resultado del partido
    private LocalDateTime fechaPartido; // Fecha y hora del partido
    private String equipos; // Equipos que juegan
    private String futbolistas; // Jugadores que participan
    private String categoriaCompetencia; // Ejemplo: Copa del Mundo, Liga
    private String arbitro;
    private String entrada;
    private String tabla;
    private String ultimosResultados;
    @OneToMany(mappedBy = "contenido")  // Relación con Reproducción (Uno a Muchos)
    private List<Reproduccion> reproducciones;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTipoVideo() {
        return tipoVideo;
    }

    public void setTipoVideo(String tipoVideo) {
        this.tipoVideo = tipoVideo;
    }

    // Getters y Setters de los atributos de fútbol
    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(LocalDateTime fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public String getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(String futbolistas) {
        this.futbolistas = futbolistas;
    }

    public String getCategoriaCompetencia() {
        return categoriaCompetencia;
    }

    public void setCategoriaCompetencia(String categoriaCompetencia) {
        this.categoriaCompetencia = categoriaCompetencia;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUltimosResultados() {
        return ultimosResultados;
    }

    public void setUltimosResultados(String ultimosResultados) {
        this.ultimosResultados = ultimosResultados;
    }

    // Getter y setter para minitura
    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }

}
