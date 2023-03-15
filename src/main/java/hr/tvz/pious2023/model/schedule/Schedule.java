package hr.tvz.pious2023.model.schedule;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** Domain class for {@link Schedule}. */
@Data
@Builder
public class Schedule {
  private Long id;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private Integer dayOfWeek;
  private Long courseId;
}
