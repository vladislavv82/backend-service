package su.xeonexus.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.xeonexus.service.dto.FormInput;
import su.xeonexus.service.model.FormData;
import su.xeonexus.service.repository.FormDataRepository;

@Service
public class FormDataService {

    private final FormDataRepository repository;

    @Autowired
    public FormDataService(FormDataRepository repository) {
        this.repository = repository;
    }

    public FormData createFormData(FormInput input) {
        FormData formData = new FormData(null, input.getName(), input.getText(), input.getPhone());
        return repository.save(formData);
    }

    // Другие методы сервиса (например, поиск, обновление, удаление)
}
