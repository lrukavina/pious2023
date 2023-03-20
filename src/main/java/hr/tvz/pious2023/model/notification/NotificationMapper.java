package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.Utils;
import hr.tvz.pious2023.model.course.CourseDto;
import hr.tvz.pious2023.model.professor.ProfessorDto;

/** Mapper class for {@link Notification} */
public class NotificationMapper {
  private NotificationMapper() {}

  public static NotificationDto domainToDto(
      Notification notification, ProfessorDto professorDto, CourseDto courseDto) {
    return NotificationDto.builder()
        .course(courseDto.getName())
        .fromDateTime(Utils.dateTimeToString(notification.getFromDateTime()))
        .toDateTime(Utils.dateTimeToString(notification.getToDateTime()))
        .header(notification.getHeader())
        .description(notification.getDescription())
        .author(
            professorDto.getTitle()
                + " "
                + professorDto.getFirstName()
                + " "
                + professorDto.getLastName())
        .build();
  }
}
