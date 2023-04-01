package hr.tvz.pious2023.model.student;

import hr.tvz.pious2023.exception.PiousException;
import hr.tvz.pious2023.model.account.AccountDto;
import hr.tvz.pious2023.model.account.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final AccountService accountService;

  @Override
  public StudentDto fetchById(Long id) {
    AccountDto account = accountService.fetchByStudentId(id);
    return StudentMapper.domainToDto(studentRepository.fetchById(id), account);
  }

  @Override
  public StudentDto fetchByAccountId(Long id) {
    AccountDto account = accountService.fetchByAccountId(id);
    return StudentMapper.domainToDto(studentRepository.fetchByAccountId(id), account);
  }

  @Override
  @Transactional
  public void registerStudent(Student student) {
    studentRepository.registerStudent(student);
  }

  @Override
  public Optional<StudentDto> editStudentProfile(EditStudentForm editStudentForm) {
    Student student = studentRepository.fetchByAccountId(editStudentForm.getAccountId());

    if (student == null) {
      throw new PiousException("Student ne postoji u bazi podataka.");
    }

    AccountDto account = accountService.fetchByAccountId(student.getAccountId());

    StudentMapper.updateStudent(editStudentForm, student);
    studentRepository.updateStudent(student);

    return Optional.of(StudentMapper.domainToDto(student, account));
  }
}
