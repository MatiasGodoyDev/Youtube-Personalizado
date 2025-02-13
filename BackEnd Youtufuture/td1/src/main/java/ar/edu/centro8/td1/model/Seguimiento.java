package ar.edu.centro8.td1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Users user;  // Cambié "usuario" por "user"

    @ManyToOne
    @JoinColumn(name = "canal_id")
    private Canal canal;

    private LocalDateTime fechaSeguimiento;
    private boolean notificaciones;
    private String prioridad; // O enum Prioridad {ALTA, MEDIA, BAJA;}
    private String urlUltimaActividad;
    private String categoriaPreferida;
    // Asegúrate de tener un atributo como este:
    private String nombreCanal;


    // Constructor
    public Seguimiento() {
    }

    public Seguimiento(Users user, Canal canal) {
        this.user = user;
        this.canal = canal;
    }
    
}
