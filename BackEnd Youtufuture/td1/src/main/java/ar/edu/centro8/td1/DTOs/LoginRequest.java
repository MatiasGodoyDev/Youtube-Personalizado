package ar.edu.centro8.td1.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginRequest {
    private String emailOrUsersName;
    private String contraseña;


    public String getEmailOrUsersName() {
        return emailOrUsersName;
    }
    
    public void setEmailOrUsersName(String emailOrUsersName) {
        this.emailOrUsersName = emailOrUsersName;
    }    
    
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

}
