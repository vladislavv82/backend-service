package su.xeonexus.service.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySenderAndRecipient(String sender, String recipient);
}
