package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.model.role.Role;
import lombok.Builder;
import lombok.Data;

/** DTO class for {@link Account}. */
@Data
@Builder
public class AccountDto {
  private String username;
  private String email;
  private String phone;
  private String image;
  private Role role;
}
