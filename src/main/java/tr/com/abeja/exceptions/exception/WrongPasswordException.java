package tr.com.abeja.exceptions.exception;

public class WrongPasswordException extends GeneralException {
    public WrongPasswordException(String code, String message) {
        super(code, message);
    }
}