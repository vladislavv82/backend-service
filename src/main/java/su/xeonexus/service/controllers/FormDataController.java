package su.xeonexus.service.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.xeonexus.service.dto.FormInput;
import su.xeonexus.service.model.FormData;
import su.xeonexus.service.service.FormDataService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontend.xeonexus.su/")
@RequestMapping("/api")
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

    @GetMapping("/form-data/{id}")
    public ResponseEntity<?> getFormData(@PathVariable Long id) {
        try {
            FormData formData = service.getFormDataById(id);
            return ResponseEntity.ok(formData);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/form-data")
    public ResponseEntity<List<FormData>> getAllFormData() {
        List<FormData> formDataList = service.getAllFormData();
        return ResponseEntity.ok(formDataList);
    }

    // Другие обработчики запросов (например, GET, PUT, DELETE)
}
