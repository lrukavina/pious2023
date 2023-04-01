package hr.tvz.pious2023.model.course;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/** Form used for {@link Course} model. */
@Data
@Builder
public class CourseForm {
  private String name;
  private Integer ects;
  private String description;
  private Integer semester;
  private String literature;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  private List<Integer> professors;
}
