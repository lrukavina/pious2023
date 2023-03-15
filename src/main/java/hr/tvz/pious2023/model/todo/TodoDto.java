package hr.tvz.pious2023.model.todo;

import lombok.Builder;
import lombok.Data;

/** DTO class for {@link Todo} */
@Data
@Builder
public class TodoDto {
  private String fromDateTime;
  private String toDateTime;
  private String header;
  private String description;
}
