package hr.tvz.pious2023.model.schedule;

import java.util.List;

public interface ScheduleService {
  /**
   * Fetches Schedule by course id
   *
   * @param id course id
   * @return schedule Dto objects
   */
  List<ScheduleDto> fetchByCourseId(Long id);

  /**
   * Fetches Schedule by student id
   * @param id student id
   * @return schedule Dto objects
   */
  List<ScheduleDto> fetchByStudentId(Long id);
}
