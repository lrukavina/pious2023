package hr.tvz.pious2023.model.student;

import java.util.Optional;

public interface StudentService {
  /**
   * Fetches Student by id
   *
   * @param id student id
   * @return student Dto object
   */
  StudentDto fetchById(Long id);

  /**
   * Fetches Student by account id
   *
   * @param id student id
   * @return student Dto object
   */
  StudentDto fetchByAccountId(Long id);

  /**
   * Registers (saves) new student into database
   *
   * @param student student to be saved
   */
  void registerStudent(Student student);

  /**
   * Updates information about student
   *
   * @param editStudentForm Form with updated student's data
   * @return updated student
   */
  Optional<StudentDto> editStudentProfile(EditStudentForm editStudentForm);
}
