package guru.springframework.repositories;

import guru.springframework.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
