package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.model.schedule.ScheduleForm;
import hr.tvz.pious2023.model.schedule.ScheduleMapper;
import hr.tvz.pious2023.model.schedule.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;
  private final CourseValidator courseValidator;
  private final ScheduleRepository scheduleRepository;

  @Override
  public CourseDto fetchById(Long id) {
    return CourseMapper.domainToDto(courseRepository.fetchById(id));
  }

  @Override
  public List<CourseDto> fetchAllByStudentId(Long id) {
    return courseRepository.fetchAllByStudentId(id).stream()
        .map(CourseMapper::domainToDto)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<CourseDto> saveCourse(CourseForm courseForm) {
    courseValidator.isFormValid(courseForm);
    Course course = CourseMapper.formToDomain(courseForm);
    courseRepository.saveCourse(course);
    saveCourseProfessors(courseForm.getProfessors(), course.getId());
    saveCourseSchedule(courseForm, course.getId());
    return Optional.of(CourseMapper.domainToDto(course));
  }

  private void saveCourseProfessors(List<Integer> professors, Long courseId) {
    for (Integer professorId : professors) {
      courseRepository.saveCourseProfessors(professorId, courseId);
    }
  }

  private void saveCourseSchedule(CourseForm courseForm, Long courseId) {
    ScheduleForm scheduleForm = CourseMapper.formToScheduleForm(courseForm, courseId);
    scheduleRepository.saveSchedule(ScheduleMapper.formToDomain(scheduleForm));
  }
}
