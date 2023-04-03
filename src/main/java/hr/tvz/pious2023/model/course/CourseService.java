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
   * Fetches all courses with grades and student GPA and ect points for student by student id
   *
   * @param id student id
   * @return course dto objects
   */
  CourseGradeWrapperDto fetchAllWithGradeByAccountId(Long id);

  /**
   * Fetches all courses for account by account id
   *
   * @param id account id
   * @return course dto objects
   */
  List<CourseDto> fetchAllByAccountId(Long id);

  /**
   * Saves new course
   *
   * @param courseForm Course form
   * @return saved Course dto
   */
  Optional<CourseDto> saveCourse(CourseForm courseForm);

  /**
   * Enrolls course for Student
   *
   * @param courseEnrollmentForm Course enrollment form
   */
  void enrollCourse(CourseEnrollmentForm courseEnrollmentForm);

  List<CourseDto> fetchAllNotEnrolledByAccountId(Long id);
}
