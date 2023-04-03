package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.model.professor.ProfessorDto;
import hr.tvz.pious2023.model.professor.ProfessorMapper;
import hr.tvz.pious2023.model.schedule.ScheduleForm;

import java.math.BigDecimal;
import java.util.List;

/** Mapper class for {@link Course} */
public class CourseMapper {
  private CourseMapper() {}

  public static CourseDto domainToDto(Course course) {
    return CourseDto.builder()
        .id(course.getId())
        .name(course.getName())
        .ects(course.getEcts())
        .description(course.getDescription())
        .semester(course.getSemester())
        .literature(course.getLiterature())
        .build();
  }

  public static CourseDto domainToViewDto(Course course, List<ProfessorDto> professors) {
    CourseDto courseDto = domainToDto(course);
    courseDto.setProfessors(ProfessorMapper.buildProfessorBasicInfoList(professors));
    return courseDto;
  }

  public static Course formToDomain(CourseForm form) {
    return Course.builder()
        .name(form.getName())
        .ects(form.getEcts())
        .description(form.getDescription())
        .semester(form.getSemester())
        .literature(form.getLiterature())
        .build();
  }

  public static ScheduleForm formToScheduleForm(CourseForm form, Long courseId) {
    return ScheduleForm.builder()
        .fromDateTime(form.getFromDateTime())
        .toDateTime(form.getToDateTime())
        .courseId(courseId)
        .build();
  }

  public static CourseGradeDto domainToGradeDto(Course course, Integer grade) {
    return CourseGradeDto.builder()
        .id(course.getId())
        .name(course.getName())
        .ects(course.getEcts())
        .description(course.getDescription())
        .semester(course.getSemester())
        .literature(course.getLiterature())
        .grade(grade)
        .build();
  }

  public static CourseGradeWrapperDto dtoToWrapperDto(
      List<CourseGradeDto> courses, BigDecimal gpa, Integer ectPoint) {
    return CourseGradeWrapperDto.builder().courses(courses).gpa(gpa).ects(ectPoint).build();
  }
}
