package hr.tvz.pious2023.model.grade;

import hr.tvz.pious2023.exception.PiousException;
import hr.tvz.pious2023.model.student.Student;
import hr.tvz.pious2023.model.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {
  private final GradeRepository gradeRepository;
  private final GradeValidator gradeValidator;
  private final StudentRepository studentRepository;

  @Override
  @Transactional
  public Optional<Grade> saveGrade(GradeForm gradeForm) {
    Student student = studentRepository.fetchByAccountId(gradeForm.getAccountId());
    gradeValidator.isFormValid(gradeForm, student);
    Grade grade = GradeMapper.formToDomain(gradeForm, student.getId());
    try {
      gradeRepository.saveGrade(grade);
    } catch (Exception e) {
      throw new PiousException(
          "Dogodila se greška kod upisa ocjene. Molimo osvježite stranicu i pokušajte ponovno.");
    }
    return Optional.of(grade);
  }
}
