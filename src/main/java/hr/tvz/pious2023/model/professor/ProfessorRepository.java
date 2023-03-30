package hr.tvz.pious2023.model.professor;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProfessorRepository {
  Professor fetchById(Long id);

  Professor fetchByCourseId(Long id);

  void registerProfessor(Professor professor);
}
