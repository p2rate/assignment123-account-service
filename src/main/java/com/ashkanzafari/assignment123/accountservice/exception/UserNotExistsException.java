package com.ashkanzafari.assignment123.accountservice.exception;

public class UserNotExistsException extends RuntimeException{

  public UserNotExistsException() {
  }

  public UserNotExistsException(String message) {
    super(message);
  }

  public UserNotExistsException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserNotExistsException(Throwable cause) {
    super(cause);
  }
}
