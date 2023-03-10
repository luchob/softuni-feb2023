package bg.softuni.caching.repository;

import bg.softuni.caching.model.StudentDTO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

  private Logger logger = LoggerFactory.getLogger(StudentRepository.class);

  public List<StudentDTO> findAllStudents() {
    logger.info("Downloading students...");
    dummyWait();
    logger.info("Students downloaded...");
    return List.of(
        new StudentDTO().setName("Pesho").setAge(21),
        new StudentDTO().setName("Anna").setAge(22)
    );
  }

  private void dummyWait() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
