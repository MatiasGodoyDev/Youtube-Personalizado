package ar.edu.centro8.td1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter@Setter
public class MetodosDePago {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users usuario; // Relación con la tabla Users
    private String tipo; // Ejemplo: "Tarjeta de crédito", "Débito", "PayPal"
    private String numero; // Número de tarjeta o identificador
    private LocalDate expiracion; // Fecha de vencimiento de la tarjeta
    private String estado; // Ejemplo: "pagado", "pago no realizado"
    private String nombreTitular; // Nombre del propietario del método de pago
    private LocalDate fechaCreacion; // Fecha en que se registró el pago
    private String pais; // País de emisión
    private float saldoDisponible; // Saldo disponible para pagos
    private String moneda; // Moneda utilizada
    private String codigoAutorizacion; // Código de autorización único
    private LocalDate fechaUltimoPago; // Última vez que se utilizó
    private boolean activo; // Si el método está activo
    private String tipoSuscripcion; // Ejemplo: "Premium", "Estándar"
    private float montoUltimoPago; // Monto del último pago realizado
    private String periodicidad; // Ejemplo: "mensual", "anual"
    
    // metodos de pago
    private String correoPaypal;
    private String cuentaBancaria;
    private LocalDate fechaInicio; // Fecha de inicio de la suscripción
    private LocalDate fechaVencimiento; // Fecha de vencimiento de la suscripción
    private float monto; // Monto del pago por la suscripción
    private String periodicidadSuscripcion; // Ejemplo: "mensual", "anual"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(LocalDate expiracion) {
        this.expiracion = expiracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public LocalDate getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(LocalDate fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public float getMontoUltimoPago() {
        return montoUltimoPago;
    }

    public void setMontoUltimoPago(float montoUltimoPago) {
        this.montoUltimoPago = montoUltimoPago;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    // Métodos relacionados a la suscripción
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getPeriodicidadSuscripcion() {
        return periodicidadSuscripcion;
    }

    public void setPeriodicidadSuscripcion(String periodicidadSuscripcion) {
        this.periodicidadSuscripcion = periodicidadSuscripcion;
    }

    // Métodos específicos para Paypal y Transferencia
    public String getCorreoPaypal() {
        return correoPaypal;
    }

    public void setCorreoPaypal(String correoPaypal) {
        this.correoPaypal = correoPaypal;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

}
