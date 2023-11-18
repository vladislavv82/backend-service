package su.xeonexus.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.xeonexus.service.model.FormData;

    public interface FormDataRepository extends JpaRepository<FormData, Long> {
    }