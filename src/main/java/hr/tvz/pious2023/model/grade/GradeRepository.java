package hr.tvz.pious2023.model.grade;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GradeRepository {
  void saveGrade(Grade grade);
}
