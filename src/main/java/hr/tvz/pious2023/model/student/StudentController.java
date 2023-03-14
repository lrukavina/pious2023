package hr.tvz.pious2023.model.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/** Controller class for {@link Student}. */
@RestController
@AllArgsConstructor
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/{id}")
  public StudentDto getById(@PathVariable final String id) {
    return studentService.fetchById(Long.valueOf(id));
  }
}
