package hr.tvz.pious2023.model.professor;

import lombok.Builder;
import lombok.Data;

/** DTO class for {@link Professor} */
@Data
@Builder
public class ProfessorDto {
  private String firstName;
  private String lastName;
  private String title;
  private String location;
  private String consultations;
  // todo add AccountDto
}
