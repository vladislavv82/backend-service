package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithRole {
    private String uid;
    private String name;
    private String email;
    private String role;

    // Геттеры и сеттеры
}