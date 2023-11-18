package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    public UserCreateRequest(String email,String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;

    }

    private String email;
    private String name;
    private String password;

    // геттеры и сеттеры
}
