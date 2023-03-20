package hr.tvz.pious2023.model.notification;

import java.util.List;

public interface NotificationService {
  /**
   * Fetches all notifications by course id
   *
   * @param id course id
   * @return notifications dto objects
   */
  List<NotificationDto> fetchAllByCourseId(Long id);

  /**
   * Fetches all notifications for student's courses.
   *
   * @param id student id
   * @return notifications dto objects
   */
  List<NotificationDto> fetchAllByStudentId(Long id);
}
