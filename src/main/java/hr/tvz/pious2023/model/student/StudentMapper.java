package hr.tvz.pious2023.model.student;

import hr.tvz.pious2023.model.account.AccountDto;

/** Mapper class for {@link Student} */
public class StudentMapper {
  private StudentMapper() {}

  public static StudentDto domainToDto(Student student, AccountDto account) {
    return StudentDto.builder()
        .jmbag(student.getJmbag())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .occupation(student.getOccupation())
        .address(student.getAddress())
        .scholarship(student.isScholarship())
        .account(account)
        .build();
  }
}
