package ar.edu.centro8.td1.DTOs;
import ar.edu.centro8.td1.model.Users;

public class FollowRequest {
    private Users user;
    private String nombreCanal;

    // Getters y setters
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }
}
