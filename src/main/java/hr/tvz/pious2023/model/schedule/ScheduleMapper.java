package hr.tvz.pious2023.model.schedule;

/** Mapper class for {@link Schedule} */
public class ScheduleMapper {
  private ScheduleMapper() {}

  public static ScheduleDto domainToDto(Schedule schedule) {
    return ScheduleDto.builder()
        .fromDateTime(schedule.getFromDateTime())
        .toDateTime(schedule.getToDateTime())
        .dayOfWeek(schedule.getDayOfWeek())
        .build();
  }
}
