package hr.tvz.pious2023.model.course;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Course}. */
@RestController
@AllArgsConstructor
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {

  private final CourseService courseService;

  @GetMapping("/{id}")
  public CourseDto getById(@PathVariable final String id) {
    return courseService.fetchById(Long.valueOf(id));
  }

  @GetMapping("/account/{id}")
  public List<CourseDto> getByAccountId(@PathVariable final String id) {
    return courseService.fetchAllByAccountId(Long.valueOf(id));
  }

  @GetMapping("/notEnrolled/account/{id}")
  public List<CourseDto> getNotEnrolledByAccountId(@PathVariable final String id) {
    return courseService.fetchAllNotEnrolledByAccountId(Long.valueOf(id));
  }

  @PostMapping("/save")
  public ResponseEntity<CourseDto> saveCourse(@RequestBody final CourseForm courseForm) {
    return courseService
        .saveCourse(courseForm)
        .map(course -> ResponseEntity.status(HttpStatus.CREATED).body(course))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }

  @GetMapping("/grades/account/{id}")
  public CourseGradeWrapperDto getGradesByAccountId(@PathVariable final String id) {
    return courseService.fetchAllWithGradeByAccountId(Long.valueOf(id));
  }

  @PostMapping("/enroll")
  public void enrollCourse(@RequestBody final CourseEnrollmentForm courseEnrollmentForm) {
    courseService.enrollCourse(courseEnrollmentForm);
  }
}
