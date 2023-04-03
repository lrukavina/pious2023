package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.Utils;
import hr.tvz.pious2023.exception.PiousException;
import hr.tvz.pious2023.model.grade.Grade;
import hr.tvz.pious2023.model.grade.GradeService;
import hr.tvz.pious2023.model.professor.ProfessorDto;
import hr.tvz.pious2023.model.professor.ProfessorService;
import hr.tvz.pious2023.model.schedule.ScheduleForm;
import hr.tvz.pious2023.model.schedule.ScheduleMapper;
import hr.tvz.pious2023.model.schedule.ScheduleRepository;
import hr.tvz.pious2023.model.student.Student;
import hr.tvz.pious2023.model.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;
  private final CourseValidator courseValidator;
  private final ScheduleRepository scheduleRepository;
  private final StudentRepository studentRepository;
  private final ProfessorService professorService;
  private final GradeService gradeService;

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
  public CourseGradeWrapperDto fetchAllWithGradeByAccountId(Long id) {
    Student student = studentRepository.fetchByAccountId(id);
    if (student == null) {
      throw new PiousException("Student ne postoji u bazi podataka.");
    }

    List<Course> courses = courseRepository.fetchAllByStudentId(student.getId());
    List<Integer> grades = new ArrayList<>();
    List<CourseGradeDto> courseGrades = new ArrayList<>();
    Integer ects = 0;

    for (Course course : courses) {
      Grade courseGrade = gradeService.fetchByStudentsCourse(student.getId(), course.getId());
      if (courseGrade == null) {
        continue;
      }

      grades.add(courseGrade.getGrade());
      courseGrades.add(CourseMapper.domainToGradeDto(course, courseGrade.getGrade()));
      ects += course.getEcts();
    }
    if (grades.isEmpty()) {
      return null;
    }

    BigDecimal gpa = Utils.calculateGpa(grades);
    return CourseMapper.dtoToWrapperDto(courseGrades, gpa, ects);
  }

  @Override
  public List<CourseDto> fetchAllByAccountId(Long id) {

    List<Course> courses = courseRepository.fetchAllByAccountId(id);

    List<CourseDto> courseDtos = new ArrayList<>();
    for (Course course : courses) {
      List<ProfessorDto> professors = professorService.fetchByCourseId(course.getId());
      courseDtos.add(CourseMapper.domainToViewDto(course, professors));
    }
    return courseDtos;
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
