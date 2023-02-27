package bg.softuni.hateoas.model.dto;

public class OrderDTO {

  private long studentId;
  private long courseId;

  public long getStudentId() {
    return studentId;
  }

  public OrderDTO setStudentId(long studentId) {
    this.studentId = studentId;
    return this;
  }

  public long getCourseId() {
    return courseId;
  }

  public OrderDTO setCourseId(long courseId) {
    this.courseId = courseId;
    return this;
  }
}
