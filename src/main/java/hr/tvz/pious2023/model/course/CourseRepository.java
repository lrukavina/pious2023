package hr.tvz.pious2023.model.course;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CourseRepository {
  Course fetchById(Long id);
}
