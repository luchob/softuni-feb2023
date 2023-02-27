package bg.softuni.data.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

  private final StudentRepository studentRepository;

  public DBInit(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (studentRepository.count() == 0) {
      studentRepository.save(new StudentEntity().setFirstName("Pesho").setLastName("Petrov"));
      studentRepository.save(new StudentEntity().setFirstName("Anna").setLastName("Ivanova"));
    }
  }
}
