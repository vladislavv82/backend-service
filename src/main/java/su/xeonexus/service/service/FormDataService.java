package su.xeonexus.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import su.xeonexus.service.dto.ExternalServiceRequest;
import su.xeonexus.service.dto.ExternalServiceResponse;
import su.xeonexus.service.dto.FormInput;
import su.xeonexus.service.model.FormData;
import su.xeonexus.service.repository.FormDataRepository;



/**
 * Создает и сохраняет объект FormData, основываясь на входных данных формы.
 * Дополнительно вызывает внешний микросервис для получения предсказанных значений.
 *
 * @param *input данные формы, введенные пользователем.
 * @return сохраненный объект FormData с предсказанными значениями.
 */

@Service
public class FormDataService {

    private final FormDataRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public FormDataService(FormDataRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;

    }

    public FormData createFormData(FormInput input) {

        // Создание нового экземпляра FormData с данными, введенными пользователем.
        FormData formData = new FormData(null, input.getName(), input.getUser_query(), input.getPhone());

        // Вызов внешнего сервиса для получения предсказаний.
        ExternalServiceResponse response = callExternalService(input.getUser_query());

        // Установка предсказанных значений в объект FormData.
        //formData.setPredictedCategory(response.getPredictedCategory());
        //formData.setPredictedImportance(response.getPredictedImportance());

        return repository.save(formData);
    }


    /**
     * Вызывает внешний микросервис для получения предсказанных данных.
     *
     * @param user_query текст для анализа внешним сервисом.
     * @return ответ от внешнего сервиса с предсказанными значениями.
     */
      private ExternalServiceResponse callExternalService(String user_query) {
        // Создание запроса для внешнего сервиса с нужным текстом.
        ExternalServiceRequest request = new ExternalServiceRequest();
        request.setUser_query(user_query);

        // URL внешнего сервиса
        String url = "http://127.0.0.1:8000/predict/";
        // Отправка запроса и получение ответа от внешнего сервиса.
        return restTemplate.postForObject(url, request, ExternalServiceResponse.class);
    }
}
