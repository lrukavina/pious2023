package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.exception.PiousException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class CourseValidator {
  public void isFormValid(CourseForm courseForm) {
    if (courseForm.getEcts() <= 0) {
      throw new PiousException("Broj ECTS bodova nije validan.");
    }

    if (courseForm.getSemester() <= 0 || courseForm.getSemester() > 10) {
      throw new PiousException("Broj semestra nije validan.");
    }

    if (courseForm.getProfessors().isEmpty()) {
      throw new PiousException("Molimo odaberite barem jednog profesora na kolegiju.");
    }
  }
}
