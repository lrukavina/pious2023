package hr.tvz.pious2023.model.notification;

import lombok.Builder;
import lombok.Data;

/** DTO class for {@link Notification} */
@Data
@Builder
public class NotificationDto {
  private String fromDateTime;
  private String toDateTime;
  private String header;
  private String description;
  private String author;
}
