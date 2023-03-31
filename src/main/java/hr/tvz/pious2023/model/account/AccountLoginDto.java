package hr.tvz.pious2023.model.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/** Login DTO class for {@link Account}. */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class AccountLoginDto extends AccountDto {
  private Long id;
  private String firstName;
  private String lastName;
}
