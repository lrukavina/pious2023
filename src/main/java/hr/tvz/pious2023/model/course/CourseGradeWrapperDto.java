package hr.tvz.pious2023.model.course;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/** DTO class wrapper for {@link Course} */
@Data
@Builder
public class CourseGradeWrapperDto {
  List<CourseGradeDto> courses;
  BigDecimal gpa;
  Integer ects;
}
