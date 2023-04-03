package hr.tvz.pious2023;

import hr.tvz.pious2023.model.account.AccountForm;
import hr.tvz.pious2023.model.student.StudentDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/** Utils class for all entities in application. */
public class Utils {
  private Utils() {}

  public static String dateTimeToString(LocalDateTime dateTime) {
    return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))
        + " u "
        + dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH"))
        + "h";
  }

  public static String buildEmailBody(StudentDto studentDto, String body) {
    StringBuilder builder = new StringBuilder();
    String bodyHeader = "Student: " + studentDto.getFirstName() + " " + studentDto.getLastName();
    String jmbag = "Jmbag: " + studentDto.getJmbag();

    return builder
        .append(bodyHeader)
        .append("<br>")
        .append(jmbag)
        .append("<br>")
        .append("Šalje Vam e-mail:")
        .append("<br>")
        .append("<br>")
        .append("<hr>")
        .append(body)
        .append("<br>")
        .append("<hr>")
        .append("<b><i> Molimo odgovorite na studentov e-mail: </i></b>")
        .append("<a href = \"mailto: lrukavina@tvz.hr\">lrukavina@tvz.hr</a>")
        .append("<br>")
        .append("<b><i>Ovo je automatska poruka, molimo nemojte odgovarati na nju. </b></i>")
        .toString();
  }

  public static String buildUsername(AccountForm accountForm) {
    return (accountForm.getFirstName().charAt(0) + accountForm.getLastName()).toLowerCase();
  }

  public static BigDecimal calculateGpa(List<Integer> grades) {
    BigDecimal gpa = new BigDecimal("0");
    for (Integer grade : grades) {
      gpa = gpa.add(BigDecimal.valueOf(grade));
    }
    return gpa.divide(BigDecimal.valueOf(grades.size()), 2, RoundingMode.HALF_UP);
  }
}
