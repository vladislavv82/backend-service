package su.xeonexus.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalServiceResponse {
    public ExternalServiceResponse(
            @JsonProperty("predicted_category") String predicted_category,
            @JsonProperty("predicted_importance") String predicted_importance
    ) {
        this.predicted_category = predicted_category;
        this.predicted_importance = predicted_importance;
    }

    private String predicted_category;
    private String predicted_importance;

    // конструкторы, геттеры и сеттеры
}