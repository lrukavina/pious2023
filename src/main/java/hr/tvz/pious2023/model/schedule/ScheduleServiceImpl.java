package hr.tvz.pious2023.model.schedule;

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
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final CourseService courseService;
  private final ProfessorService professorService;

  @Override
  public List<ScheduleDto> fetchByCourseId(Long id) {
    CourseDto courseDto = courseService.fetchById(id);

    ProfessorDto professorDto = professorService.fetchByCourseId(id);
    List<Schedule> schedules = scheduleRepository.fetchByCourseId(id);

    List<ScheduleDto> scheduleDtos = new ArrayList<>();
    for (Schedule schedule : schedules) {
      List<ScheduleDto> entries;
      entries = ScheduleMapper.getAllScheduleEntries(schedule, courseDto, professorDto);
      scheduleDtos.addAll(entries);
    }

    return scheduleDtos;
  }
}
