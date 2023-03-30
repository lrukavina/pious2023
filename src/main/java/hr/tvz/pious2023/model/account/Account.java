package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.model.role.Role;
import lombok.Builder;
import lombok.Data;

/** Domain class for {@link Account}. */
@Data
@Builder
public class Account {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String image;
  private Role role;
}
