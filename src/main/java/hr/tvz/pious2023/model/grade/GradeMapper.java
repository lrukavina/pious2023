package hr.tvz.pious2023.model.grade;

/** Mapper class for {@link Grade} */
public class GradeMapper {
  private GradeMapper() {}

  public static Grade formToDomain(GradeForm form) {
    return Grade.builder()
        .studentId(form.getStudentId())
        .courseId(form.getCourseId())
        .grade(form.getGrade())
        .build();
  }
}
