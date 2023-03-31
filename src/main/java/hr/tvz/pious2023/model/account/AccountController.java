package hr.tvz.pious2023.model.account;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Controller class for {@link Account}. */
@RestController
@AllArgsConstructor
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

  private final AccountService accountService;

  @GetMapping
  public List<AccountDto> getAll() {
    return accountService.fetchAll();
  }

  @GetMapping("/{id}")
  public AccountDto getAccountById(@PathVariable final String id) {
    return accountService.fetchByAccountId(Long.valueOf(id));
  }

  @PostMapping
  public ResponseEntity<String> saveAccount(@RequestBody final AccountForm accountForm) {
    String email = accountService.registerAccount(accountForm);
    if (email != null) {
      return ResponseEntity.status(HttpStatus.OK).body(email);
    }
    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
  }

  @PostMapping("/login")
  public ResponseEntity<AccountDto> loginAccount(@RequestBody final LoginForm loginForm) {
    return accountService
        .loginAccount(loginForm)
        .map(account -> ResponseEntity.status(HttpStatus.CREATED).body(account))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }
}
