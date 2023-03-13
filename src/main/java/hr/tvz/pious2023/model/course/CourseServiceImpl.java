package hr.tvz.pious2023.model.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  @Override
  public CourseDto fetchById(Long id) {
    return CourseMapper.domainToDto(courseRepository.fetchById(id));
  }
}
