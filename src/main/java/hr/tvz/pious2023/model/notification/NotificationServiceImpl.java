package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.model.professor.Professor;
import hr.tvz.pious2023.model.professor.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  private final ProfessorRepository professorRepository;

  @Override
  public List<NotificationDto> fetchAllByCourseId(Long id) {
    List<Notification> notifications = notificationRepository.fetchAllByCourseId(id);
    List<Professor> professors =
        notifications.stream()
            .map(notification -> professorRepository.fetchById(notification.getProfessorId()))
            .toList();

    List<NotificationDto> notificationsDto = new ArrayList<>();
    for (int i = 0; i < notifications.size(); i++) {
      notificationsDto.add(NotificationMapper.domainToDto(notifications.get(i), professors.get(i)));
    }
    return notificationsDto;
  }
}
