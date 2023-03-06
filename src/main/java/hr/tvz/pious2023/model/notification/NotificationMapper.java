package hr.tvz.pious2023.model.notification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Mapper class for {@link Notification} */
public class NotificationMapper {
  private NotificationMapper() {}

  public static NotificationDto domainToDto(Notification notification) {
    return NotificationDto.builder()
        .fromDateTime(dateTimeToString(notification.getFromDateTime()))
        .toDateTime(dateTimeToString(notification.getToDateTime()))
        .header(notification.getHeader())
        .description(notification.getDescription())
        .build();
    // todo add professor name and title as author String
  }

  private static String dateTimeToString(LocalDateTime dateTime) {
    return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))
        + " u "
        + dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH"))
        + "h";
  }
}
