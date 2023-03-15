package hr.tvz.pious2023.model.schedule;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ScheduleRepository {
  List<Schedule> fetchByCourseId(Long id);
}
