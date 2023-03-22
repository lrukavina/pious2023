package hr.tvz.pious2023.email;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class MailSenderController {

  private final MailSenderService mailSenderService;

  @PostMapping
  public void sendEmail(@RequestBody final MailSenderForm mailSenderForm) {
    mailSenderService.sendEmail(mailSenderForm);
  }
}
