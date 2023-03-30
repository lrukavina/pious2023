package hr.tvz.pious2023.model.professor;

import hr.tvz.pious2023.model.account.AccountDto;

/** Mapper class for {@link Professor} */
public class ProfessorMapper {
  private ProfessorMapper() {}

  public static ProfessorDto domainToDto(Professor professor, AccountDto account) {
    return ProfessorDto.builder()
        .firstName(professor.getFirstName())
        .lastName(professor.getLastName())
        .title(professor.getTitle())
        .location(professor.getLocation())
        .consultations(professor.getConsultations())
        .account(account)
        .build();
  }
}
