package tr.com.abeja.exceptions.exception;

public class EmployeeNotFoundException extends GeneralException {
    public EmployeeNotFoundException(String code, String message) {
        super(code, message);
    }
}