package hr.tvz.pious2023.model.schedule;

import java.util.List;

public interface ScheduleService {
  /**
   * Fetches Schedule by course id
   *
   * @param id course id
   * @return schedule Dto object
   */
  List<ScheduleDto> fetchByCourseId(Long id);
}
