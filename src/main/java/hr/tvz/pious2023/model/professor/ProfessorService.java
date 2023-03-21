package hr.tvz.pious2023.model.professor;

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
}
