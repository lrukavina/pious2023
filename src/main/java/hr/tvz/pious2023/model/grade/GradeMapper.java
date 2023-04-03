package hr.tvz.pious2023.model.grade;

/** Mapper class for {@link Grade} */
public class GradeMapper {
  private GradeMapper() {}

  public static Grade formToDomain(GradeForm form, Long studentId) {
    return Grade.builder()
        .studentId(studentId)
        .courseId(form.getCourseId())
        .grade(form.getGrade())
        .build();
  }
}
