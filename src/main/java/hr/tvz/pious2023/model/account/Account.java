package hr.tvz.pious2023.model.account;

import lombok.Builder;
import lombok.Data;

/** Domain class for Account. */
@Data
@Builder
public class Account {
  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;
  private String image;
}
