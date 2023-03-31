package hr.tvz.pious2023.model.account;

import hr.tvz.pious2023.exception.PiousException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class AccountValidator {

  public void isFormValid(AccountForm accountForm) {
    if (accountForm.getJmbag().length() != 10) {
      log.error(
          "Account form for new account: {} {} is not valid!",
          accountForm.getFirstName(),
          accountForm.getLastName());
      throw new PiousException("Molimo upišite ispravan JMBAG");
    }
  }
}
