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
  public List<TodoDto> getByAccountId(@PathVariable final String id) {
    return todoService.fetchByAccountId(Long.valueOf(id));
  }
}
