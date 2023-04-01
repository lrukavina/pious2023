package hr.tvz.pious2023.model.schedule;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** Form used for {@link Schedule} model. */
@Data
@Builder
public class ScheduleForm {
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private Long courseId;
}
