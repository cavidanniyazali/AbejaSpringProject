package tr.com.abeja.exceptions.exception;

public class EmployeeAlreadyExist extends GeneralException{
    public EmployeeAlreadyExist(String code, String message) {
        super(code, message);
    }
}