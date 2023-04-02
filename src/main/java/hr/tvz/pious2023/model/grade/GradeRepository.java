package hr.tvz.pious2023.model.grade;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GradeRepository {

  Grade fetchByStudentsCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

  void saveGrade(Grade grade);
}
