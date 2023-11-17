package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormInput {
    public FormInput(String name, String text, String phone) {
        this.name = name;
        this.text = text;
        this.phone = phone;
    }

    private String name;
    private String text;
    private String phone;

    // Геттеры и сеттеры для каждого поля
}