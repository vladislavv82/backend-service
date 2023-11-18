package su.xeonexus.service.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.xeonexus.service.dto.FormInput;
import su.xeonexus.service.model.FormData;
import su.xeonexus.service.service.FormDataService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FormDataController {

    private final FormDataService service;

    @Autowired
    public FormDataController(FormDataService service) {
        this.service = service;
    }

    @PostMapping("/submit-form")
    public ResponseEntity<?> createFormData(@Valid @RequestBody FormInput input) {
        FormData formData = service.createFormData(input);
        return ResponseEntity.ok(formData);
    }

    // Другие обработчики запросов (например, GET, PUT, DELETE)
}
