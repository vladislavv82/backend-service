package su.xeonexus.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="form")
@Getter
@Setter
public class FormData {
    public FormData(Long id, String name, String user_query, String phone) {
        this.id = id;
        this.name = name;
        this.user_query = user_query;
        this.phone = phone;

    }

    public FormData() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String user_query;
    private String phone;

    private String predictedCategory;
    private String predictedImportance;

    // Геттеры, сеттеры, конструкторы
}