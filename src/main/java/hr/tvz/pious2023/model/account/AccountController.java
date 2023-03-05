package hr.tvz.pious2023.model.account;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/** Controller class for {@link Account}. */
@RestController
@AllArgsConstructor
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/{id}")
  public AccountDto getAccountById(@PathVariable final String id) {
    return accountService.fetchByAccountId(Long.valueOf(id));
  }
}
