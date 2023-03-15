package hr.tvz.pious2023.model.schedule;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

  private final ScheduleRepository scheduleRepository;

  @Override
  public List<ScheduleDto> fetchByCourseId(Long id) {
    return scheduleRepository.fetchByCourseId(id).stream()
        .map(ScheduleMapper::domainToDto)
        .collect(Collectors.toList());
  }
}
