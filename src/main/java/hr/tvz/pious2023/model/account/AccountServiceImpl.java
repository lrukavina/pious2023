package hr.tvz.pious2023.model.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository;

  @Override
  public AccountDto fetchByAccountId(Long id) {
    return AccountMapper.domainToDto(accountRepository.fetchById(id));
  }
}
