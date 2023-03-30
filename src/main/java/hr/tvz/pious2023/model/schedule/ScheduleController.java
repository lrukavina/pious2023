package hr.tvz.pious2023.model.schedule;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Schedule}. */
@RestController
@AllArgsConstructor
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {
  private final ScheduleService scheduleService;

  @GetMapping("/course/{id}")
  public List<ScheduleDto> getByCourseId(@PathVariable final String id) {
    return scheduleService.fetchByCourseId(Long.valueOf(id));
  }

  @GetMapping("/student/{id}")
  public List<ScheduleDto> getByStudentId(@PathVariable final String id) {
    return scheduleService.fetchByStudentId(Long.valueOf(id));
  }
}
