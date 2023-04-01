package hr.tvz.pious2023.model.professor;

import lombok.Builder;
import lombok.Data;

/** Form used for editing {@link Professor} model. */
@Data
@Builder
public class EditProfessorForm {
  private Long accountId;
  private String title;
  private String location;
  private String consultations;
}
