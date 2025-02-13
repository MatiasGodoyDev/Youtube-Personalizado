package ar.edu.centro8.td1.model;

import java.time.LocalDateTime;

import ar.edu.centro8.td1.Enum.EstadoReproduccion;
import ar.edu.centro8.td1.Enum.TipoReproduccion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Reproduccion {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")  // Relación con Usuario
    private Users usuario;
    @ManyToOne
    @JoinColumn(name = "contenido")  // Relación con Contenido (Video)
    private Contenido contenido;
    private LocalDateTime  fechaReproduccion;
    private int duracion;
    @Enumerated(EnumType.STRING)
    private EstadoReproduccion estado;
    private float porcentajeCompletado;
    @Enumerated(EnumType.STRING)
    private TipoReproduccion tipoReproduccion;
    private String calidad;
    private String dispositivo;
    private int tiempoReanudacion;
    


    public Reproduccion() {
    }



}
