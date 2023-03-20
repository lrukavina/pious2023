package hr.tvz.pious2023.model.notification;

import hr.tvz.pious2023.model.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Account}. */
@RestController
@AllArgsConstructor
@RequestMapping("/notification")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {

  private final NotificationService notificationService;

  @GetMapping("/{id}")
  public List<NotificationDto> getAllByCourseId(@PathVariable final String id) {
    return notificationService.fetchAllByCourseId(Long.valueOf(id));
  }

  @GetMapping("/student/{id}")
  public List<NotificationDto> getAllByStudentId(@PathVariable final String id) {
    return notificationService.fetchAllByStudentId(Long.valueOf(id));
  }
}
