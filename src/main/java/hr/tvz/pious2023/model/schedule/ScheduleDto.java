package hr.tvz.pious2023.model.schedule;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/** Domain class for {@link Schedule}. */
@Data
@Builder
public class ScheduleDto {
  private String title;
  private List<String> professors;
  private String location;
  private String timeFrom;
  private String timeTo;
  private String date;
}
