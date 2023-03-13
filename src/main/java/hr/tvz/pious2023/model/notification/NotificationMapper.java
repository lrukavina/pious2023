package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.model.professor.Professor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Mapper class for {@link Notification} */
public class NotificationMapper {
  private NotificationMapper() {}

  public static NotificationDto domainToDto(Notification notification, Professor professor) {
    return NotificationDto.builder()
        .fromDateTime(dateTimeToString(notification.getFromDateTime()))
        .toDateTime(dateTimeToString(notification.getToDateTime()))
        .header(notification.getHeader())
        .description(notification.getDescription())
        .author(professor.getFirstName() + " " + professor.getLastName())
        .build();
  }

  private static String dateTimeToString(LocalDateTime dateTime) {
    return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))
        + " u "
        + dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH"))
        + "h";
  }
}
