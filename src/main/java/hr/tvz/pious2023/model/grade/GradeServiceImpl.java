package hr.tvz.pious2023.model.grade;

import hr.tvz.pious2023.exception.PiousException;
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
    try {
      gradeRepository.saveGrade(grade);
    } catch (Exception e) {
      throw new PiousException("Navedeni student ili kolegij ne postoji u bazi podataka.");
    }
    return Optional.of(grade);
  }
}
