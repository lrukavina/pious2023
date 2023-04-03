package hr.tvz.pious2023.model.course;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/** DTO class for {@link Course} */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class CourseGradeDto extends CourseDto {
  private Integer grade;
}
