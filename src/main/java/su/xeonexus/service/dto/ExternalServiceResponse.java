package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServiceResponse {
    public ExternalServiceResponse(String predicted_category, String predicted_importance) {
        this.predicted_category = predicted_category;
        this.predicted_importance = predicted_importance;
    }

    private String predicted_category;
    private String predicted_importance;

    // конструкторы, геттеры и сеттеры
}