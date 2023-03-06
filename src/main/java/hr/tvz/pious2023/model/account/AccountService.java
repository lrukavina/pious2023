package hr.tvz.pious2023.model.account;

import java.util.List;

public interface AccountService {
  List<AccountDto> fetchAll();

  AccountDto fetchByAccountId(Long id);
}
