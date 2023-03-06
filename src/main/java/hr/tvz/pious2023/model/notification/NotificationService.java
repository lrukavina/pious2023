package hr.tvz.pious2023.model.notification;

import java.util.List;

public interface NotificationService {
  /**
   * Fetches all notifications by course id
   *
   * @param id course id
   * @return notifications
   */
  List<NotificationDto> fetchAllByCourseId(Long id);
}
