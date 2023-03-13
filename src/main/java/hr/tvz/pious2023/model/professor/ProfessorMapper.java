package hr.tvz.pious2023.model.professor;

/** Mapper class for {@link Professor} */
public class ProfessorMapper {
  private ProfessorMapper() {}

  public static ProfessorDto domainToDto(Professor professor) {
    return ProfessorDto.builder()
        .firstName(professor.getFirstName())
        .lastName(professor.getLastName())
        .title(professor.getTitle())
        .location(professor.getLocation())
        .consultations(professor.getConsultations())
        .build();
  }
}
