package hr.tvz.pious2023;

import hr.tvz.pious2023.model.student.StudentDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        .append(System.getProperty("line.separator"))
        .append(jmbag)
        .append(System.getProperty("line.separator"))
        .append(System.getProperty("line.separator"))
        .append(body)
        .toString();
  }
}
