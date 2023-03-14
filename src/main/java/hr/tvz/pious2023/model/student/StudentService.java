package hr.tvz.pious2023.model.student;

public interface StudentService {
  /**
   * Fetches Student by id
   *
   * @param id student id
   * @return student Dto object
   */
  StudentDto fetchById(Long id);
}
