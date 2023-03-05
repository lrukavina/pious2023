package hr.tvz.pious2023.model.account;

import lombok.Builder;
import lombok.Data;

/** DTO class for Account domain class. */
@Data
@Builder
public class AccountDto {
  private String username;
  private String email;
  private String phone;
  private String image;
}
