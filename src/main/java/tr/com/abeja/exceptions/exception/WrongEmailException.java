package tr.com.abeja.exceptions.exception;

public class WrongEmailException extends GeneralException {
    public WrongEmailException(String code, String message) {
        super(code, message);
    }
}