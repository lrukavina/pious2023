package hr.tvz.pious2023.model.todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
  /**
   * Fetches Todos by account id
   *
   * @param id account id
   * @return Todos Dto objects
   */
  List<TodoDto> fetchActiveByAccountId(Long id);

  Optional<TodoDto> saveTodo(TodoForm todoForm);
}
