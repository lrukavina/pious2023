package hr.tvz.pious2023.model.grade;

import lombok.Builder;
import lombok.Data;

/** Domain class for {@link Grade}. */
@Data
@Builder
public class Grade {
  private Long studentId;
  private Long courseId;
  private Integer grade;
}
