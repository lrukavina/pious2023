package hr.tvz.pious2023.model.student;

import lombok.Builder;
import lombok.Data;

/** Domain class for Professor. */
@Data
@Builder
public class Student {
  private Long id;
  private String jmbag;
  private String firstName;
  private String lastName;
  private String occupation;
  private String address;
  private boolean scholarship;
  private Long accountId;
}
