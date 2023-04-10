package hr.tvz.pious2023.model.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class AccountServiceImplTest {

  AccountService accountService;
  private static final Long PROFESSOR_ACCOUNT_ID = 1L;
  private static final Long STUDENT_ACCOUNT_ID = 2L;

  @BeforeEach
  void setUp() {
    accountService = Mockito.mock(AccountService.class);
  }

  @Test
  void fetchAll() {

    Mockito.when(accountService.fetchAll()).thenReturn(accounts());

    List<AccountDto> accounts = accountService.fetchAll();
    Assertions.assertFalse(accounts.isEmpty());
    Assertions.assertEquals(2, accounts.size());
  }

  @Test
  void fetchByAccountId() {
    Mockito.when(accountService.fetchByAccountId(PROFESSOR_ACCOUNT_ID))
        .thenReturn(accounts().get(0));

    AccountDto account = accountService.fetchByAccountId(PROFESSOR_ACCOUNT_ID);
    Assertions.assertNotNull(account);
    Assertions.assertEquals(account.getId(), PROFESSOR_ACCOUNT_ID);
  }

  @Test
  void fetchByStudentId() {
    Mockito.when(accountService.fetchByStudentId(STUDENT_ACCOUNT_ID)).thenReturn(accounts().get(1));

    AccountDto account = accountService.fetchByStudentId(STUDENT_ACCOUNT_ID);
    Assertions.assertNotNull(account);
    Assertions.assertEquals(account.getId(), STUDENT_ACCOUNT_ID);
  }

  @Test
  void fetchByProfessorId() {
    Mockito.when(accountService.fetchByProfessorId(PROFESSOR_ACCOUNT_ID)).thenReturn(accounts().get(0));

    AccountDto account = accountService.fetchByProfessorId(PROFESSOR_ACCOUNT_ID);
    Assertions.assertNotNull(account);
    Assertions.assertEquals(account.getId(), PROFESSOR_ACCOUNT_ID);
  }

  private List<AccountDto> accounts() {
    AccountDto professor = AccountDto.builder().id(PROFESSOR_ACCOUNT_ID).build();
    AccountDto student = AccountDto.builder().id(STUDENT_ACCOUNT_ID).build();
    return List.of(professor, student);
  }
}
