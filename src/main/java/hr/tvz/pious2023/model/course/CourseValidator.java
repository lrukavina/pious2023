package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.exception.PiousException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

    LocalDateTime dateTimeFrom = courseForm.getFromDateTime();
    LocalDateTime dateTimeTo = courseForm.getToDateTime();
    isDateTimeValid(dateTimeFrom, dateTimeTo);
  }

  /**
   * Checks are dates and times valid from form
   *
   * @param dateTimeFrom date time from
   * @param dateTimeTo date time to
   */
  public void isDateTimeValid(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
    if (dateTimeFrom == null || dateTimeTo == null) {
      throw new PiousException("Molimo popunite podatke o trajanju kolegija.");
    }

    if (dateTimeFrom.isEqual(dateTimeTo)) {
      throw new PiousException("Datum i vrijeme od i datum i vrijeme do ne smiju biti jednaki.");
    }

    if (!dateTimeFrom.isBefore(dateTimeTo)) {
      throw new PiousException("Datum i vrijeme od mora biti nakon datuma i vremena do.");
    }
  }
}
