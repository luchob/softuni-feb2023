package bg.softuni.caching.service;

import bg.softuni.caching.model.StudentDTO;
import bg.softuni.caching.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceIfc{

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Cacheable("students")
  @Override
  public List<StudentDTO> getAllStudents() {
    return studentRepository.findAllStudents();
  }

  @Cacheable("students")
  @Override
  public Optional<StudentDTO> getStudentByName(String name) {

    return studentRepository.
        findAllStudents().
        stream().
        filter(s -> s.getName().equals(name)).
        findAny();
  }

  @CacheEvict(cacheNames = "students", allEntries = true)
  @Override
  public void refreshStudents() {
  }
}
