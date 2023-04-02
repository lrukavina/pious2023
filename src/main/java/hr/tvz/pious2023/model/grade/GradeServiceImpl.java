package hr.tvz.pious2023.model.grade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {
  private final GradeRepository gradeRepository;
  private final GradeValidator gradeValidator;

  @Override
  public Optional<Grade> saveGrade(GradeForm gradeForm) {
    gradeValidator.isFormValid(gradeForm);
    Grade grade = GradeMapper.formToDomain(gradeForm);
    gradeRepository.saveGrade(grade);
    return Optional.of(grade);
  }
}
