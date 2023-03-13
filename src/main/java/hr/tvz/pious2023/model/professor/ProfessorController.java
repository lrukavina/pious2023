package hr.tvz.pious2023.model.professor;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/** Controller class for {@link Professor}. */
@RestController
@AllArgsConstructor
@RequestMapping("/professor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {

  private final ProfessorService professorService;

  @GetMapping("/{id}")
  public ProfessorDto getById(@PathVariable final String id) {
    return professorService.fetchById(Long.valueOf(id));
  }
}
