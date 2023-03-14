package hr.tvz.pious2023.model.student;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentRepository {
  Student fetchById(Long id);
}
