package hr.tvz.pious2023;

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
}
