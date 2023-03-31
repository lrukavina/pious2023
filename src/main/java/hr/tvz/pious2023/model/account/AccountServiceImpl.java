package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.Utils;
import hr.tvz.pious2023.model.professor.Professor;
import hr.tvz.pious2023.model.professor.ProfessorMapper;
import hr.tvz.pious2023.model.professor.ProfessorRepository;
import hr.tvz.pious2023.model.role.Role;
import hr.tvz.pious2023.model.student.Student;
import hr.tvz.pious2023.model.student.StudentMapper;
import hr.tvz.pious2023.model.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository;
  private final AccountValidator validator;
  private final PasswordEncoder passwordEncoder;
  private final StudentRepository studentRepository;
  private final ProfessorRepository professorRepository;

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

  @Override
  @Transactional
  public String registerAccount(AccountForm accountForm) {
    validator.isFormValid(accountForm);
    String formUsername = Utils.buildUsername(accountForm);
    Account latestAccount = accountRepository.fetchLastByUsername(formUsername + "%");

    return latestAccount == null
        ? registerNewAccount(accountForm)
        : registerFromExistingAccount(latestAccount, accountForm);
  }

  private String registerNewAccount(AccountForm accountForm) {
    Account account = AccountMapper.buildBaseAccount(accountForm);
    account.setPassword(encodePassword(accountForm.getPassword()));
    account.setRole(accountForm.getRole());

    accountRepository.registerAccount(account);
    accountRepository.insertRole(account.getRole(), account.getId());
    registerPerson(account, accountForm);
    return account.getEmail();
  }

  private String encodePassword(String rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }

  private String registerFromExistingAccount(Account latestAccount, AccountForm accountForm) {
    Account newAccount = AccountMapper.buildBaseAccountFromExisting(latestAccount);
    newAccount.setPassword(encodePassword(accountForm.getPassword()));
    newAccount.setRole(accountForm.getRole());

    accountRepository.registerAccount(newAccount);
    accountRepository.insertRole(newAccount.getRole(), newAccount.getId());
    registerPerson(newAccount, accountForm);
    return newAccount.getEmail();
  }

  /**
   * Registers person associated to saved account (Student or Professor)
   *
   * @param account Saved account
   * @param accountForm Form that has the data for person that needs to be saved
   */
  private void registerPerson(Account account, AccountForm accountForm) {

    if (Role.STUDENT.equals(accountForm.getRole())) {
      Student student = StudentMapper.buildStudentDomain(accountForm, account.getId());
      studentRepository.registerStudent(student);
      return;
    }
    Professor professor = ProfessorMapper.buildProfessorDomain(accountForm, account.getId());
    professorRepository.registerProfessor(professor);
  }
}
