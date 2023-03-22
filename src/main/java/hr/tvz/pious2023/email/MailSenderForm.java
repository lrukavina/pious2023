package hr.tvz.pious2023.email;

import lombok.Builder;
import lombok.Data;

/** MailSender form class. */
@Data
@Builder
public class MailSenderForm {
  private String emailTo;
  private String header;
  private String body;
  private Long studentId;
}
