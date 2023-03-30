package hr.tvz.pious2023.model.student;

import hr.tvz.pious2023.model.account.AccountDto;
import hr.tvz.pious2023.model.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
