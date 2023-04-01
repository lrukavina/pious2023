package hr.tvz.pious2023.model.professor;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProfessorRepository {
  List<Professor> fetchAll();

  Professor fetchById(Long id);

  Professor fetchByCourseId(Long id);

  Professor fetchByAccountId(Long id);

  void registerProfessor(Professor professor);

  void updateProfessor(Professor professor);
}
