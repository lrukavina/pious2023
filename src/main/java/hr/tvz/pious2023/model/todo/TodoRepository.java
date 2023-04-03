package hr.tvz.pious2023.model.todo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TodoRepository {
  List<Todo> fetchActiveByAccountId(Long id);
}
