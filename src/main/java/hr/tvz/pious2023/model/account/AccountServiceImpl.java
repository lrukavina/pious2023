package hr.tvz.pious2023.model.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository;

  @Override
  public List<AccountDto> fetchAll() {
    return accountRepository.fetchAll().stream()
        .map(AccountMapper::domainToDto)
        .collect(Collectors.toList());
  }

  @Override
  public AccountDto fetchByAccountId(Long id) {
    return AccountMapper.domainToDto(accountRepository.fetchById(id));
  }

  @Override
  public AccountDto fetchByStudentId(Long id) {
    return AccountMapper.domainToDto(accountRepository.fetchByStudentId(id));
  }

  @Override
  public AccountDto fetchByProfessorId(Long id) {
    return AccountMapper.domainToDto(accountRepository.fetchByProfessorId(id));
  }
}
