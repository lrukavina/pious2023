package hr.tvz.pious2023.model.professor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

  private final ProfessorRepository professorRepository;

  @Override
  public ProfessorDto fetchById(Long id) {
    return ProfessorMapper.domainToDto(professorRepository.fetchById(id));
  }
}
