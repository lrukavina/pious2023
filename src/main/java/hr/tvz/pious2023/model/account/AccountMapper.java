package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.Utils;

/** Mapper class for {@link Account} */
public class AccountMapper {
  private AccountMapper() {}

  private static final String emailExtension = "@tvz.hr";

  public static AccountDto domainToDto(Account account) {
    return AccountDto.builder()
        .username(account.getUsername())
        .email(account.getEmail())
        .phone(account.getPhone())
        .image(account.getImage())
        .role(account.getRole())
        .build();
  }

  public static Account buildBaseAccount(AccountForm accountForm) {
    String username = Utils.buildUsername(accountForm);
    return Account.builder().username(username).email(username + emailExtension).build();
  }

  public static Account buildBaseAccountFromExisting(Account account) {
    String username = account.getUsername();
    char lastChar = account.getUsername().charAt(username.length() - 1);

    if (!Character.isDigit(lastChar)) {
      return Account.builder()
          .username(account.getUsername() + "1")
          .email(account.getUsername() + "1" + emailExtension)
          .build();
    }

    String newUsername = account.getUsername().substring(0, account.getUsername().length() - 1);
    int lastNumber = Integer.parseInt(String.valueOf(lastChar));
    lastNumber++;
    newUsername = newUsername + lastNumber;
    return Account.builder().username(newUsername).email(newUsername + emailExtension).build();
  }
}
