package hr.tvz.pious2023.model.course;

/** Mapper class for {@link Course} */
public class CourseMapper {
  private CourseMapper() {}

  public static CourseDto domainToDto(Course course) {
    return CourseDto.builder()
        .name(course.getName())
        .ects(course.getEcts())
        .description(course.getDescription())
        .semester(course.getSemester())
        .literature(course.getLiterature())
        .build();
  }
}
