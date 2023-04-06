package hr.tvz.pious2023.model.todo;

import hr.tvz.pious2023.Utils;

import java.time.LocalDateTime;

/** Mapper class for {@link Todo} */
public class TodoMapper {
  private TodoMapper() {}

  private static final int TIME_DIFFERENCE = 2;

  public static TodoDto domainToDto(Todo todo) {
    return TodoDto.builder()
        .fromDateTime(Utils.dateTimeToString(todo.getFromDateTime()))
        .toDateTime(Utils.dateTimeToString(todo.getToDateTime()))
        .header(todo.getHeader())
        .description(todo.getDescription())
        .build();
  }

  public static Todo formToDomain(TodoForm form) {
    LocalDateTime dateTimeFrom = form.getFromDateTime().plusHours(TIME_DIFFERENCE);
    LocalDateTime dateTimeTo = form.getToDateTime().plusHours(TIME_DIFFERENCE);

    return Todo.builder()
        .fromDateTime(dateTimeFrom)
        .toDateTime(dateTimeTo)
        .header(form.getHeader())
        .description(form.getDescription())
        .accountId(form.getAccountId())
        .build();
  }
}
