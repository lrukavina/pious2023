package hr.tvz.pious2023.model.todo;

import hr.tvz.pious2023.model.course.CourseValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Slf4j
@Component
public class TodoValidator {
  private final CourseValidator courseValidator;

  public void isFormValid(TodoForm todoForm) {
    LocalDateTime dateTimeFrom = todoForm.getFromDateTime();
    LocalDateTime dateTimeTo = todoForm.getToDateTime();
    courseValidator.isDateTimeValid(dateTimeFrom, dateTimeTo);
  }
}
