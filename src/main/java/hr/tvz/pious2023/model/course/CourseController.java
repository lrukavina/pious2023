package hr.tvz.pious2023.model.course;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/save")
  public ResponseEntity<CourseDto> saveCourse(@RequestBody final CourseForm courseForm) {
    return courseService
        .saveCourse(courseForm)
        .map(course -> ResponseEntity.status(HttpStatus.CREATED).body(course))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }
}
