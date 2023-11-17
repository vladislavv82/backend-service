package su.xeonexus.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="form")
@Getter
@Setter
public class FormData {
    public FormData(Long id, String name, String text, String phone) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
    private String phone;

    // Геттеры, сеттеры, конструкторы
}