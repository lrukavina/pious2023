package hr.tvz.pious2023.model.student;

import hr.tvz.pious2023.model.account.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO class for {@link Student} */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
  private String jmbag;
  private String firstName;
  private String lastName;
  private String occupation;
  private String address;
  private boolean scholarship;
  private AccountDto account;
}
