package hr.tvz.pious2023.model.student;

import lombok.Builder;
import lombok.Data;

/** Form used for editing {@link Student} model. */
@Data
@Builder
public class EditStudentForm {
  private Long accountId;
  private String occupation;
  private String address;
  private boolean scholarship;
}
