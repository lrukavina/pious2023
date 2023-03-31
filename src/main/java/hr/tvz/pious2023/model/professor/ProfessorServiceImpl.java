package hr.tvz.pious2023.model.professor;

import hr.tvz.pious2023.model.account.AccountDto;
import hr.tvz.pious2023.model.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

  private final ProfessorRepository professorRepository;
  private final AccountService accountService;

  @Override
  public ProfessorDto fetchById(Long id) {
    AccountDto account = accountService.fetchByProfessorId(id);
    return ProfessorMapper.domainToDto(professorRepository.fetchById(id), account);
  }

  @Override
  public ProfessorDto fetchByCourseId(Long id) {
    AccountDto account = accountService.fetchByProfessorId(id);
    return ProfessorMapper.domainToDto(professorRepository.fetchByCourseId(id), account);
  }

  @Override
  public ProfessorDto fetchByAccountId(Long id) {
    AccountDto account = accountService.fetchByAccountId(id);
    return ProfessorMapper.domainToDto(professorRepository.fetchByAccountId(id), account);
  }

  @Override
  public void registerProfessor(Professor professor) {
    professorRepository.registerProfessor(professor);
  }
}
