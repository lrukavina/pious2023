package hr.tvz.pious2023.model.course;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/** DTO class for {@link Course} */
@Data
@Builder
public class CourseDto {
  private Long id;
  private String name;
  private Integer ects;
  private String description;
  private Integer semester;
  private String literature;
  private List<String> professors;
}
