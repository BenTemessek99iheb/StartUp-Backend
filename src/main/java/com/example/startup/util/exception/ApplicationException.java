package com.example.startup.util.exception;

public class ApplicationException extends RuntimeException {

  public ApplicationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplicationException(String message) {
    super(message);
  }
}
