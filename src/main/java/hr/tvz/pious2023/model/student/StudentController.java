package hr.tvz.pious2023.model.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Student}. */
@RestController
@AllArgsConstructor
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/all")
  public List<StudentDto> getAll() {
    return studentService.fetchAll();
  }

  @GetMapping("/{id}")
  public StudentDto getById(@PathVariable final String id) {
    return studentService.fetchByAccountId(Long.valueOf(id));
  }

  @PostMapping("/update")
  public ResponseEntity<StudentDto> updateStudent(
      @RequestBody final EditStudentForm editStudentForm) {
    return studentService
        .editStudentProfile(editStudentForm)
        .map(student -> ResponseEntity.status(HttpStatus.CREATED).body(student))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }
}
