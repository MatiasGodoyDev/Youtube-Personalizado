package ar.edu.centro8.td1.DTOs;

public class PagarRequest {
    private Double monto;
    private Long userId; // ID del usuario que realiza el pago
    private String plan;
    private String tipoPago;  // Puede ser "Tarjeta" o "PayPal"
    
    // Para tarjeta de crédito/débito
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoAutorizacion;
    
    // Para PayPal
    private String correoPayPal;
    private String contrasenaPayPal;

    // Getters y setters

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public String getCorreoPayPal() {
        return correoPayPal;
    }

    public void setCorreoPayPal(String correoPayPal) {
        this.correoPayPal = correoPayPal;
    }

    public String getContrasenaPayPal() {
        return contrasenaPayPal;
    }

    public void setContrasenaPayPal(String contrasenaPayPal) {
        this.contrasenaPayPal = contrasenaPayPal;
    }
}
