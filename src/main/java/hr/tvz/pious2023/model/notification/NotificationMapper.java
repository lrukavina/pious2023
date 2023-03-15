package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.Utils;
import hr.tvz.pious2023.model.professor.Professor;

/** Mapper class for {@link Notification} */
public class NotificationMapper {
  private NotificationMapper() {}

  public static NotificationDto domainToDto(Notification notification, Professor professor) {
    return NotificationDto.builder()
        .fromDateTime(Utils.dateTimeToString(notification.getFromDateTime()))
        .toDateTime(Utils.dateTimeToString(notification.getToDateTime()))
        .header(notification.getHeader())
        .description(notification.getDescription())
        .author(professor.getFirstName() + " " + professor.getLastName())
        .build();
  }
}
