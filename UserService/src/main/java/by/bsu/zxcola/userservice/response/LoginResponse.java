package by.bsu.zxcola.userservice.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

}