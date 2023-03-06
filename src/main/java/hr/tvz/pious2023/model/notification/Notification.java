package hr.tvz.pious2023.model.notification;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** Domain class for Notification. */
@Data
@Builder
public class Notification {
  private Long id;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private String header;
  private String description;
  private Long professorId;
  private Long courseId;
}
