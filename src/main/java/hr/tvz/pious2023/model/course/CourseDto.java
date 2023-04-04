package hr.tvz.pious2023.model.course;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/** DTO class for {@link Course} */
@Data
@SuperBuilder
@NoArgsConstructor
public class CourseDto {
  private Long id;
  private String name;
  private Integer ects;
  private String description;
  private Integer semester;
  private String literature;
  private List<String> professors;
}
