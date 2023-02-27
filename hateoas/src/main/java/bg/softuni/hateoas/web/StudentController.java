package bg.softuni.hateoas.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.apache.coyote.Response;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> all() {

    List<EntityModel<StudentDTO>> entityModels = studentService.getAllStudents().
        stream().map(
            s -> EntityModel.of(s, getStudentLinks(s))).toList();

    CollectionModel<EntityModel<StudentDTO>> collectionModel =
        CollectionModel.of(entityModels);

    return ResponseEntity.ok(collectionModel);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntityModel<StudentDTO>> getStudentById(@PathVariable("id") Long id) {
    var studentOpt = studentService.getStudentById(id);

    return studentOpt.
        map(studentDTO -> ResponseEntity.ok(EntityModel.of(studentDTO, getStudentLinks(studentDTO)))).
        orElseGet(() -> ResponseEntity.notFound().build());

  }

  @GetMapping("/{id}/orders")
  public ResponseEntity<StudentDTO> getStudentOrders(@PathVariable("id") Long id) {
    throw new UnsupportedOperationException("Not yet");
  }

  @PutMapping ("/{id}")
  public ResponseEntity<StudentDTO> updateStudent(
      @PathVariable("id") Long studentId,
      StudentDTO studentDTO) {
    throw new UnsupportedOperationException("Not yet");
  }

  private Link[] getStudentLinks(StudentDTO studentDTO) {
    List<Link> studentLinks = new ArrayList<>();

    Link selfLink = linkTo(
        methodOn(StudentController.class).getStudentById(studentDTO.getId())).
        withSelfRel();

    studentLinks.add(selfLink);

    if (!studentDTO.isDeleted()) {
      Link orderLink = linkTo(methodOn(StudentController.class).getStudentOrders(studentDTO.getId())).withRel("orders");
      Link updateLink = linkTo(methodOn(StudentController.class).updateStudent(studentDTO.getId(), studentDTO)).withRel("update");

      studentLinks.add(orderLink);
      studentLinks.add(updateLink);
    }

    return studentLinks.toArray(new Link[0]);
  }
}
