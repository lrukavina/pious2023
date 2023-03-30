package hr.tvz.pious2023.model.student;

import hr.tvz.pious2023.model.account.AccountDto;
import lombok.Builder;
import lombok.Data;

/** DTO class for {@link Student} */
@Data
@Builder
public class StudentDto {
  private String jmbag;
  private String firstName;
  private String lastName;
  private String occupation;
  private String address;
  private boolean scholarship;
  private AccountDto account;
}
