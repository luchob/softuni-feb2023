package bg.softuni.caching.service;

import bg.softuni.caching.model.StudentDTO;
import java.util.List;
import java.util.Optional;

public interface StudentServiceIfc {

  List<StudentDTO> getAllStudents();

  Optional<StudentDTO> getStudentByName(String name);

  void refreshStudents();
}
