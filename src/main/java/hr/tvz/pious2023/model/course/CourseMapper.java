package hr.tvz.pious2023.model.course;

import hr.tvz.pious2023.model.schedule.ScheduleForm;

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
}
