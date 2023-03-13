package hr.tvz.pious2023.model.professor;

import lombok.Builder;
import lombok.Data;

/** Domain class for Professor. */
@Data
@Builder
public class Professor {
  private Long id;
  private String firstName;
  private String lastName;
  private String title;
  private String location;
  private String consultations;
  private Long accountId;
}
