package hr.tvz.pious2023.email;

import hr.tvz.pious2023.Utils;
import hr.tvz.pious2023.model.Constants;
import hr.tvz.pious2023.model.student.StudentDto;
import hr.tvz.pious2023.model.student.StudentService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailSenderServiceImpl implements MailSenderService {

  private final StudentService studentService;
  private final JavaMailSender javaMailSender;

  @Override
  public void sendEmail(MailSenderForm form) {
    StudentDto studentDto = studentService.fetchByAccountId(form.getAccountId());
    try {
      MimeMessage mimeMessage = javaMailSender.createMimeMessage();
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

      mimeMessageHelper.setFrom(Constants.universityEmail);
      mimeMessageHelper.setTo(Constants.universityEmail);
      mimeMessageHelper.setSubject(form.getHeader());
      mimeMessageHelper.setText(Utils.buildEmailBody(studentDto, form.getBody()), true);
      javaMailSender.send(mimeMessage);
    } catch (Exception e) {
      log.error("Mail sender service not available");
    }
  }
}
