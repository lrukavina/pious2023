package hr.tvz.pious2023.model.professor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO class for dropdown list for {@link Professor} */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDropdownDto {
  private Long id;
  private String firstName;
  private String lastName;
}
