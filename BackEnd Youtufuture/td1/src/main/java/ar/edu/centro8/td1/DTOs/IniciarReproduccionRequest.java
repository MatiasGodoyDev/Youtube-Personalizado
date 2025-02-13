package ar.edu.centro8.td1.DTOs;
import ar.edu.centro8.td1.model.Contenido;
import ar.edu.centro8.td1.model.Users;
import ar.edu.centro8.td1.Enum.TipoReproduccion;

public class IniciarReproduccionRequest {

    private Users usuario;
    private Contenido contenido;
    private String dispositivo;
    private TipoReproduccion tipoReproduccion;
    private String calidad;

    // Getters and Setters
    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public TipoReproduccion getTipoReproduccion() {
        return tipoReproduccion;
    }

    public void setTipoReproduccion(TipoReproduccion tipoReproduccion) {
        this.tipoReproduccion = tipoReproduccion;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
}
