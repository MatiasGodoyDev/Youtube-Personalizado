package ar.edu.centro8.td1.model;
import java.time.LocalDateTime;
import java.util.List;

import ar.edu.centro8.td1.Enum.EstadoInteraccion;
import ar.edu.centro8.td1.Enum.TipoInteraccion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Interaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @ManyToOne
    @JoinColumn(name = "user_id")
    private Users usuario;
    @ManyToOne
    @JoinColumn(name = "contenido")
    private Contenido contenido;
    private TipoInteraccion tipoInteraccion;
    private String Comentarios;
    private LocalDateTime fecha;
    private boolean like;
    private boolean notlike;
    private boolean compartido;
    private float rating;

    private List<String> etiquetas;
    private String reacciones;
    private String origen;
    private String urlMultimedia;
    private EstadoInteraccion estadoInteraccion;



    public Interaccion() {
    }


    
}