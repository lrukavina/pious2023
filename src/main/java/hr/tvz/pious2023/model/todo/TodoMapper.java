package hr.tvz.pious2023.model.todo;

import hr.tvz.pious2023.Utils;

/** Mapper class for {@link Todo} */
public class TodoMapper {
  private TodoMapper() {}

  public static TodoDto domainToDto(Todo todo) {
    return TodoDto.builder()
        .fromDateTime(Utils.dateTimeToString(todo.getFromDateTime()))
        .toDateTime(Utils.dateTimeToString(todo.getToDateTime()))
        .header(todo.getHeader())
        .description(todo.getDescription())
        .build();
  }
}
