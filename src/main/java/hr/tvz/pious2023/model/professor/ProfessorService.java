package hr.tvz.pious2023.model.professor;

import java.util.Optional;

public interface ProfessorService {
  /**
   * Fetches Professor by id
   *
   * @param id professor id
   * @return professor Dto object
   */
  ProfessorDto fetchById(Long id);

  /**
   * Fetches Professor by course id
   *
   * @param id course id
   * @return professor Dto object
   */
  ProfessorDto fetchByCourseId(Long id);

  /**
   * Fetches Professor by account id.
   *
   * @param id account id
   * @return professor Dto object
   */
  ProfessorDto fetchByAccountId(Long id);

  /**
   * Registers (saves) new professor into database
   *
   * @param professor professor to be saved
   */
  void registerProfessor(Professor professor);

  /**
   * Updates information about professor
   *
   * @param editProfessorForm Form with updated professor's data
   * @return updated professor
   */
  Optional<ProfessorDto> editProfessor(EditProfessorForm editProfessorForm);
}
