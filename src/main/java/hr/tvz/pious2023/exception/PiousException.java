package hr.tvz.pious2023.exception;

import java.util.List;

public class PiousException extends RuntimeException {

  public PiousException(String message) {
    super(message);
  }

  public PiousException(String message, Throwable cause) {
    super(message, cause);
  }

  public PiousException(Throwable cause) {
    super(cause);
  }

  public PiousException(List<String> errors) {}
}
