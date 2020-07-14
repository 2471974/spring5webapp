package guru.springframework.repositories;

import guru.springframework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
