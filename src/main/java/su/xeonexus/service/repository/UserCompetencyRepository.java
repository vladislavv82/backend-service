package su.xeonexus.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.xeonexus.service.model.UserCompetency;

import java.util.Optional;

public interface UserCompetencyRepository extends JpaRepository<UserCompetency, Long> {
    Optional<UserCompetency> findByUid(String uid);
}
