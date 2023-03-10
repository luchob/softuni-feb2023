package bg.softuni.caching.web;

import bg.softuni.caching.model.StudentDTO;
import bg.softuni.caching.service.StudentServiceIfc;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentServiceIfc studentService;

  public StudentController(StudentServiceIfc studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students/all")
  public ResponseEntity<List<StudentDTO>> findAll() {

    List<StudentDTO> studentDTOS = studentService.getAllStudents();

    studentDTOS.forEach(System.out::println);

    return ResponseEntity.ok(studentDTOS);
  }

  @GetMapping("/students/find")
  public ResponseEntity<StudentDTO> findStudentByName(@RequestParam("q") String q) {
    Optional<StudentDTO> studentOpt = studentService.getStudentByName(q);

    return studentOpt.
        map(ResponseEntity::ok).
        orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/students/all/evict")
  public ResponseEntity<List<StudentDTO>> findAllAndEvict(){

    List<StudentDTO> studentDTOS = studentService.getAllStudents();

    studentService.refreshStudents();

    return ResponseEntity.ok(studentDTOS);
  }
}
