package hr.tvz.pious2023.model.todo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Todo}. */
@RestController
@AllArgsConstructor
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class TodoController {

  private final TodoService todoService;

  @GetMapping("/{id}")
  public List<TodoDto> getActiveByAccountId(@PathVariable final String id) {
    return todoService.fetchActiveByAccountId(Long.valueOf(id));
  }
}
