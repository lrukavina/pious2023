package hr.tvz.pious2023.model.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;
  // todo professor fetch for author String

  @Override
  public List<NotificationDto> fetchAllByCourseId(Long id) {
    return notificationRepository.fetchAllByCourseId(id).stream()
        .map(NotificationMapper::domainToDto)
        .collect(Collectors.toList());
  }
}
