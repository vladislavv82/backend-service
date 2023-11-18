package su.xeonexus.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormInput {
    public FormInput(String name, String user_query, String phone) {
        this.name = name;
        this.user_query = user_query;
        this.phone = phone;
    }


    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Text is mandatory")
    @Size(max = 255, message = "Text can be up to 255 characters")
    private String user_query;

    @NotBlank(message = "Phone is mandatory")
    @Pattern(regexp = "[0-9]+", message = "Phone number can only contain digits")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
    private String phone;

    // Геттеры и сеттеры для каждого поля
}