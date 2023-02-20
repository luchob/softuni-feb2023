package bg.softuni.books.repository;

import bg.softuni.books.model.entity.AuthorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

  Optional<AuthorEntity> findAuthorEntityByName(String name);
}
