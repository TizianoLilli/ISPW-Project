package org.example.ispwprogect.utils.exception;

public class SystemException extends Exception {

    public SystemException() {
      super("Ops, somehing wrong with the connection.");
    }

    public SystemException(String message) {
      super("Technical error.\n" + message);
    }

}
