package hr.tvz.pious2023.model.grade;

import hr.tvz.pious2023.exception.PiousException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class GradeValidator {

  public void isFormValid(GradeForm gradeForm) {
    if (gradeForm.getGrade() <= 0 || gradeForm.getGrade() > 5) {
      throw new PiousException("Molimo upišite ispravnu ocjenu.");
    }
  }
}
