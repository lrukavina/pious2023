package hr.tvz.pious2023.model.course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
  /**
   * Fetches course by course id
   *
   * @param id course id
   * @return course dto object
   */
  CourseDto fetchById(Long id);

  /**
   * Fetches all courses for student by student id
   *
   * @param id student id
   * @return course dto objects
   */
  List<CourseDto> fetchAllByStudentId(Long id);

  /**
   * Saves new course
   *
   * @param courseForm Course form
   * @return saved Course dto
   */
  Optional<CourseDto> saveCourse(CourseForm courseForm);
}
