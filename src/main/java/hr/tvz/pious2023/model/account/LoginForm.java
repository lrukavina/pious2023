package hr.tvz.pious2023.model.account;

import lombok.Builder;
import lombok.Data;

/** Form used for {@link hr.tvz.pious2023.model.account.Account} model. */
@Data
@Builder
public class LoginForm {
  private String email;
  private String password;
}
