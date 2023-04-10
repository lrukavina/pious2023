package hr.tvz.pious2023.model.grade;

import hr.tvz.pious2023.exception.PiousException;
import hr.tvz.pious2023.model.course.CourseRepository;
import hr.tvz.pious2023.model.student.Student;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class GradeValidator {

  private final GradeRepository gradeRepository;
  private final CourseRepository courseRepository;

  public void isFormValid(GradeForm gradeForm, Student student) {

    if (student == null) {
      throw new PiousException("Student ne postoji u bazi podataka.");
    }

    if (!isStudentEnrolled(gradeForm.getCourseId(), student.getId())) {
      throw new PiousException("Student nije upisan na kolegij.");
    }

    if (gradeForm.getGrade() <= 0 || gradeForm.getGrade() > 5) {
      throw new PiousException("Molimo upišite ispravnu ocjenu.");
    }

    Grade grade = gradeRepository.fetchByStudentsCourse(student.getId(), gradeForm.getCourseId());

    if (grade != null) {
      throw new PiousException("Student već ima upisanu ocjenu za ovaj kolegij.");
    }
  }

  private boolean isStudentEnrolled(Long courseId, Long studentId) {
    return courseRepository.fetchByCourseIdAndStudentId(courseId, studentId) != null;
  }
}
