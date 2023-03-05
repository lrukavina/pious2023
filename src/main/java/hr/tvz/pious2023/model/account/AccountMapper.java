package hr.tvz.pious2023.model.account;

/** Mapper class for {@link Account} */
public class AccountMapper {
  private AccountMapper() {}

  public static AccountDto domainToDto(Account account) {
    return AccountDto.builder()
        .username(account.getUsername())
        .email(account.getEmail())
        .phone(account.getPhone())
        .image(account.getImage())
        .build();
  }
}
