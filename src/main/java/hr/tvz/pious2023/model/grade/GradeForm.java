package hr.tvz.pious2023.model.grade;

import lombok.Builder;
import lombok.Data;

/** Form used for {@link Grade} model. */
@Data
@Builder
public class GradeForm {
  private Long studentId;
  private Long courseId;
  private Integer grade;
}
