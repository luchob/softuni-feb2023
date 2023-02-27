package bg.softuni.hateoas.service;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<StudentDTO> getAllStudents() {
    return studentRepository.
        findAll().
        stream().
        map(this::map).
        toList();
  }

  public Optional<StudentDTO> getStudentById(Long studentId) {
    return studentRepository.
        findById(studentId).
        map(this::map);
  }


  private StudentDTO map(StudentEntity studentEntity) {

    var orders = studentEntity.getOrders().stream().map(this::map).toList();

    return new StudentDTO().
        setAge(studentEntity.getAge()).
        setId(studentEntity.getId()).
        setName(studentEntity.getName()).
        setDeleted(studentEntity.isDeleted()).
        setOrders(orders);
  }

  private OrderDTO map(OrderEntity orderEntity){
    return new OrderDTO().
        setStudentId(orderEntity.getStudent().getId()).
        setCourseId(orderEntity.getCourse().getId());
  }
}
