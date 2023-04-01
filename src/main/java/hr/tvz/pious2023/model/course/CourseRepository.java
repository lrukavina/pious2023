package hr.tvz.pious2023.model.course;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseRepository {
  Course fetchById(Long id);

  List<Course> fetchAllByStudentId(Long id);

  Integer saveCourse(Course course);

  void saveCourseProfessors(
      @Param("professorId") Integer professorId, @Param("courseId") Long courseId);
}
