package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.model.role.Role;
import lombok.Builder;
import lombok.Data;

/** Form used for {@link hr.tvz.pious2023.model.account.Account} model. */
@Data
@Builder
public class AccountForm {
  private String firstName;
  private String lastName;
  private String password;
  private String jmbag;
  private Role role;
}
