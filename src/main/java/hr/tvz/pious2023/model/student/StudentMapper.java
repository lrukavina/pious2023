package hr.tvz.pious2023.model.student;

/** Mapper class for {@link Student} */
public class StudentMapper {
  private StudentMapper() {}

  public static StudentDto domainToDto(Student student) {
    return StudentDto.builder()
        .jmbag(student.getJmbag())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .occupation(student.getOccupation())
        .address(student.getAddress())
        .scholarship(student.isScholarship())
        .build();
  }
}
