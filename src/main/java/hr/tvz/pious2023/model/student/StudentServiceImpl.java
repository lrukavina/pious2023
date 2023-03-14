package hr.tvz.pious2023.model.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  public StudentDto fetchById(Long id) {
    return StudentMapper.domainToDto(studentRepository.fetchById(id));
  }
}
