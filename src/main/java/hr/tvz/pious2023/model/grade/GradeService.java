package hr.tvz.pious2023.model.grade;

import java.util.Optional;

public interface GradeService {

  Optional<Grade> saveGrade(GradeForm gradeForm);
}
