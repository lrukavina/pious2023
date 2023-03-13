package hr.tvz.pious2023.model.course;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/** Controller class for {@link Course}. */
@RestController
@AllArgsConstructor
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

  private final CourseService courseService;

  @GetMapping("/{id}")
  public CourseDto getById(@PathVariable final String id) {
    return courseService.fetchById(Long.valueOf(id));
  }
}
