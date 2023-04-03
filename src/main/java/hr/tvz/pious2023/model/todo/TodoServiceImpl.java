package hr.tvz.pious2023.model.todo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  @Override
  public List<TodoDto> fetchActiveByAccountId(Long id) {
    return todoRepository.fetchActiveByAccountId(id).stream()
        .map(TodoMapper::domainToDto)
        .collect(Collectors.toList());
  }
}
