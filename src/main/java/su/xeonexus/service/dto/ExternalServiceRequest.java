package su.xeonexus.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServiceRequest {
    public ExternalServiceRequest(String user_query) {
        this.user_query = user_query;
    }
    public ExternalServiceRequest() {
        // Пустой конструктор
    }

    private String user_query;

    // конструкторы, геттеры и сеттеры
}