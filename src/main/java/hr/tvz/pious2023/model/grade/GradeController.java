package hr.tvz.pious2023.model.grade;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller class for {@link Grade}. */
@RestController
@AllArgsConstructor
@RequestMapping("/grade")
@CrossOrigin(origins = "*")
public class GradeController {

  private final GradeService gradeService;

  @PostMapping("/save")
  public ResponseEntity<Grade> saveCourse(@RequestBody final GradeForm gradeForm) {
    return gradeService
        .saveGrade(gradeForm)
        .map(grade -> ResponseEntity.status(HttpStatus.CREATED).body(grade))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }
}
