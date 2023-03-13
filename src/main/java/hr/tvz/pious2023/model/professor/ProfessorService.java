package hr.tvz.pious2023.model.professor;

public interface ProfessorService {
  /**
   * Fetches Professor by id
   *
   * @param id professor id
   * @return professor Dto object
   */
  ProfessorDto fetchById(Long id);
}
