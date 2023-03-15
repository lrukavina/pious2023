package hr.tvz.pious2023.model.todo;

import java.util.List;

public interface TodoService {
  /**
   * Fetches Todos by account id
   *
   * @param id account id
   * @return Todos Dto objects
   */
  List<TodoDto> fetchByAccountId(Long id);
}
