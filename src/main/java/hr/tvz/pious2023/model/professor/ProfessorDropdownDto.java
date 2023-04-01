package hr.tvz.pious2023.model.professor;

import lombok.Builder;
import lombok.Data;

/** DTO class for dropdown list for {@link Professor} */
@Data
@Builder
public class ProfessorDropdownDto {
  private Long id;
  private String firstName;
  private String lastName;
}
