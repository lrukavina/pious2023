package hr.tvz.pious2023.model.schedule;

import hr.tvz.pious2023.model.Constants;
import hr.tvz.pious2023.model.course.CourseDto;
import hr.tvz.pious2023.model.professor.ProfessorDto;
import hr.tvz.pious2023.model.professor.ProfessorMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Mapper class for {@link Schedule} */
public class ScheduleMapper {
  private ScheduleMapper() {}

  public static List<ScheduleDto> getAllScheduleEntries(
      Schedule schedule, CourseDto courseDto, List<ProfessorDto> professorDtos) {
    String timeFrom =
        schedule.getFromDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    String timeTo =
        schedule.getToDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));

    LocalDate fromDate = schedule.getFromDateTime().toLocalDate();
    LocalDate toDate = schedule.getToDateTime().toLocalDate();

    List<String> dates = new ArrayList<>();
    dates.add(fromDate.toString());

    while (fromDate.plusDays(7).isBefore(toDate)) {
      fromDate = fromDate.plusDays(7);
      dates.add(fromDate.toString());
    }

    List<ScheduleDto> scheduleEntries = new ArrayList<>();
    for (String date : dates) {
      ScheduleDto scheduleDto =
          ScheduleDto.builder().timeFrom(timeFrom).timeTo(timeTo).date(date).build();
      scheduleEntries.add(scheduleDto);
    }

    return scheduleEntries.stream()
        .map(scheduleDto -> domainToDto(scheduleDto, courseDto, professorDtos))
        .collect(Collectors.toList());
  }

  public static ScheduleDto domainToDto(
      ScheduleDto scheduleDto, CourseDto courseDto, List<ProfessorDto> professorDtos) {
    scheduleDto.setTitle(courseDto.getName());
    scheduleDto.setLocation(Constants.universityName);
    scheduleDto.setProfessors(ProfessorMapper.buildProfessorBasicInfoList(professorDtos));
    return scheduleDto;
  }

  public static Schedule formToDomain(ScheduleForm form) {
    return Schedule.builder()
        .fromDateTime(form.getFromDateTime())
        .toDateTime(form.getToDateTime())
        .courseId(form.getCourseId())
        .build();
  }
}
