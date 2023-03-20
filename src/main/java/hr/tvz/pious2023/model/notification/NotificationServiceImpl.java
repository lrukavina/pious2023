package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.model.course.CourseDto;
import hr.tvz.pious2023.model.course.CourseService;
import hr.tvz.pious2023.model.professor.ProfessorDto;
import hr.tvz.pious2023.model.professor.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  private final ProfessorService professorService;
  private final CourseService courseService;

  @Override
  public List<NotificationDto> fetchAllByCourseId(Long id) {
    List<Notification> notifications = notificationRepository.fetchAllByCourseId(id);
    List<ProfessorDto> professorDtos =
        notifications.stream()
            .map(notification -> professorService.fetchById(notification.getProfessorId()))
            .toList();

    List<NotificationDto> notificationsDto = new ArrayList<>();
    for (int i = 0; i < notifications.size(); i++) {
      CourseDto courseDto = courseService.fetchById(notifications.get(i).getCourseId());
      notificationsDto.add(
          NotificationMapper.domainToDto(notifications.get(i), professorDtos.get(i), courseDto));
    }
    return notificationsDto;
  }
}
