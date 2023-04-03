package hr.tvz.pious2023.model.todo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** Form class for {@link Todo} */
@Data
@Builder
public class TodoForm {
  private Long accountId;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private String header;
  private String description;
}
