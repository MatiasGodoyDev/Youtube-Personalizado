package ar.edu.centro8.td1.DTOs;

import java.util.List;

public class ContenidoRequest {
    private String titulo;
    private String descripcion;
    private String categoria;
    private String tipoContenido;
    private int duracion;
    private List<String> etiquetas;
    
    private String nuevoTitulo;
    private String nuevaDescripcion;
    private String nuevaCategoria;
    private String nuevoTipoContenido;
    private int nuevaDuracion;
    private List<String> nuevasEtiquetas;

    // Getter y setter para miniatura
    private String miniatura;

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

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(String miniatura) {
        this.miniatura = miniatura;
    }

    // Todos los otros getters y setters existentes...

    public String getNuevoTitulo() {
        return nuevoTitulo;
    }

    public void setNuevoTitulo(String nuevoTitulo) {
        this.nuevoTitulo = nuevoTitulo;
    }

    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }

    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }

    public String getNuevaCategoria() {
        return nuevaCategoria;
    }

    public void setNuevaCategoria(String nuevaCategoria) {
        this.nuevaCategoria = nuevaCategoria;
    }

    public String getNuevoTipoContenido() {
        return nuevoTipoContenido;
    }

    public void setNuevoTipoContenido(String nuevoTipoContenido) {
        this.nuevoTipoContenido = nuevoTipoContenido;
    }

    public int getNuevaDuracion() {
        return nuevaDuracion;
    }

    public void setNuevaDuracion(int nuevaDuracion) {
        this.nuevaDuracion = nuevaDuracion;
    }

    public List<String> getNuevasEtiquetas() {
        return nuevasEtiquetas;
    }

    public void setNuevasEtiquetas(List<String> nuevasEtiquetas) {
        this.nuevasEtiquetas = nuevasEtiquetas;
    }
}
