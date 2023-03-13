package hr.tvz.pious2023.model.course;

public interface CourseService {
  /**
   * Fetches course by course id
   *
   * @param id course id
   * @return course dto object
   */
  CourseDto fetchById(Long id);
}
