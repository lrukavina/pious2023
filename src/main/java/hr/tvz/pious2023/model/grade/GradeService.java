package hr.tvz.pious2023.model.grade;

import java.util.Optional;

public interface GradeService {

  Grade fetchByStudentsCourse(Long studentId, Long courseId);

  Optional<Grade> saveGrade(GradeForm gradeForm);
}
