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
   *
   * @param id student id
   * @return schedule Dto objects
   */
  List<ScheduleDto> fetchByStudentId(Long id);

  /**
   * Fetches Schedule by account id
   *
   * @param id account id
   * @return schedule Dto objects
   */
  List<ScheduleDto> fetchByAccountId(Long id);

  /**
   * Saves Schedule for course
   *
   * @param scheduleForm Schedule form
   */
  void saveSchedule(ScheduleForm scheduleForm);
}
