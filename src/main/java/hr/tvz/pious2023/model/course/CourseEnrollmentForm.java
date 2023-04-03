package hr.tvz.pious2023.model.course;

import lombok.Builder;
import lombok.Data;

/** Form used for {@link Course} model. */
@Data
@Builder
public class CourseEnrollmentForm {
  private Long accountId;
  private Long courseId;
}
