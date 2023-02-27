package bg.softuni.data.rest;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
  Optional<StudentEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
