package no.kantega.security.api.password;

import java.util.Date;


public class DefaultResetPasswordToken implements ResetPasswordToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String key) {
        this.token = key;
    }
}
