package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    public UserCreateRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;

    // геттеры и сеттеры
}
