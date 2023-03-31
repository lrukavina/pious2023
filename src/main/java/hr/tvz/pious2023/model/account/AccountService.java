package hr.tvz.pious2023.model.account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
  List<AccountDto> fetchAll();

  AccountDto fetchByAccountId(Long id);

  AccountDto fetchByStudentId(Long id);

  AccountDto fetchByProfessorId(Long id);

  /**
   * Registers new account. In case account is registered returns account email.
   *
   * @param accountForm Account registration form
   * @return registered account email
   */
  String registerAccount(AccountForm accountForm);

  /**
   * Logs in account
   *
   * @param loginForm Account login form
   * @return logged in Account
   */
  Optional<AccountDto> loginAccount(LoginForm loginForm);
}
