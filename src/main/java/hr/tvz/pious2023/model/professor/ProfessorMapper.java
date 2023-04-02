package hr.tvz.pious2023.model.professor;

import hr.tvz.pious2023.model.account.AccountDto;
import hr.tvz.pious2023.model.account.AccountForm;

import java.util.ArrayList;
import java.util.List;

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

  public static ProfessorDropdownDto domainToDropdownDto(Professor professor) {
    return ProfessorDropdownDto.builder()
        .id(professor.getId())
        .firstName(professor.getFirstName())
        .lastName(professor.getLastName())
        .build();
  }

  public static Professor buildProfessorDomain(AccountForm accountForm, Long accountId) {
    return Professor.builder()
        .firstName(accountForm.getFirstName())
        .lastName(accountForm.getLastName())
        .accountId(accountId)
        .build();
  }

  public static void updateProfessor(EditProfessorForm form, Professor professor) {
    professor.setTitle(form.getTitle());
    professor.setLocation(form.getLocation());
    professor.setConsultations(form.getConsultations());
  }

  public static List<String> buildProfessorBasicInfoList(List<ProfessorDto> professors) {
    List<String> professorInfos = new ArrayList<>();
    for (ProfessorDto professor : professors) {
      professorInfos.add(
          professor.getTitle() + " " + professor.getFirstName() + " " + professor.getLastName());
    }
    return professorInfos;
  }
}
