package hr.tvz.pious2023.model.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  @Override
  public CourseDto fetchById(Long id) {
    return CourseMapper.domainToDto(courseRepository.fetchById(id));
  }

  @Override
  public List<CourseDto> fetchAllByStudentId(Long id) {
    return courseRepository.fetchAllByStudentId(id).stream()
        .map(CourseMapper::domainToDto)
        .collect(Collectors.toList());
  }
}
