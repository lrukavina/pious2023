package hr.tvz.pious2023.model.todo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/** Domain class for Todos . */
@Data
@Builder
public class Todo {
  private Long id;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private String header;
  private String description;
  private Long accountId;
}
