package hr.tvz.pious2023.model.professor;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Professor}. */
@RestController
@AllArgsConstructor
@RequestMapping("/professor")
@CrossOrigin("*")
public class ProfessorController {

  private final ProfessorService professorService;

  @GetMapping("/{id}")
  public ProfessorDto getById(@PathVariable final String id) {
    return professorService.fetchById(Long.valueOf(id));
  }

  @GetMapping("/dropdown")
  public List<ProfessorDropdownDto> getAllForDropdown() {
    return professorService.fetchAllForDropdown();
  }

  @PostMapping("/update")
  public ResponseEntity<ProfessorDto> updateProfessor(
      @RequestBody final EditProfessorForm editProfessorForm) {
    return professorService
        .editProfessor(editProfessorForm)
        .map(professor -> ResponseEntity.status(HttpStatus.CREATED).body(professor))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }
}
