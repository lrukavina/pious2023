package hr.tvz.pious2023.model.professor;

import hr.tvz.pious2023.exception.PiousException;
import hr.tvz.pious2023.model.account.AccountDto;
import hr.tvz.pious2023.model.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

  private final ProfessorRepository professorRepository;
  private final AccountService accountService;

  @Override
  public List<ProfessorDropdownDto> fetchAllForDropdown() {
    return professorRepository.fetchAll().stream()
        .map(ProfessorMapper::domainToDropdownDto)
        .collect(Collectors.toList());
  }

  @Override
  public ProfessorDto fetchById(Long id) {
    AccountDto account = accountService.fetchByProfessorId(id);
    return ProfessorMapper.domainToDto(professorRepository.fetchById(id), account);
  }

  @Override
  public List<ProfessorDto> fetchByCourseId(Long id) {
    List<Professor> professors = professorRepository.fetchByCourseId(id);

    List<ProfessorDto> professorDtos = new ArrayList<>();
    for (Professor professor : professors) {
      AccountDto account = accountService.fetchByProfessorId(professor.getId());
      professorDtos.add(ProfessorMapper.domainToDto(professor, account));
    }

    return professorDtos;
  }

  @Override
  public ProfessorDto fetchByAccountId(Long id) {
    AccountDto account = accountService.fetchByAccountId(id);
    return ProfessorMapper.domainToDto(professorRepository.fetchByAccountId(id), account);
  }

  @Override
  public void registerProfessor(Professor professor) {
    professorRepository.registerProfessor(professor);
  }

  @Override
  public Optional<ProfessorDto> editProfessor(EditProfessorForm editProfessorForm) {
    Professor professor = professorRepository.fetchByAccountId(editProfessorForm.getAccountId());

    if (professor == null) {
      throw new PiousException("Profesor ne postoji u bazi podataka.");
    }

    AccountDto account = accountService.fetchByAccountId(professor.getAccountId());

    ProfessorMapper.updateProfessor(editProfessorForm, professor);
    professorRepository.updateProfessor(professor);

    return Optional.of(ProfessorMapper.domainToDto(professor, account));
  }
}
