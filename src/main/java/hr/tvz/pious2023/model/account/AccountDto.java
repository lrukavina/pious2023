package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.model.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/** DTO class for {@link Account}. */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
  private Long id;
  private String username;
  private String email;
  private String phone;
  private String image;
  private Role role;
}
