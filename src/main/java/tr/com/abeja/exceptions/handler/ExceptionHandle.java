package tr.com.abeja.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tr.com.abeja.exceptions.ExceptionResponse;
import tr.com.abeja.exceptions.exception.EmployeeAlreadyExist;
import tr.com.abeja.exceptions.exception.EmployeeNotFoundException;
import tr.com.abeja.exceptions.exception.WrongEmailException;
import tr.com.abeja.exceptions.exception.WrongPasswordException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public ExceptionResponse handleUnexpectedError(RuntimeException ex) {
        log.error("Action.handleValidationException.error validate exception: {}", ex.toString());
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ExceptionResponse handleNotFoundException(EmployeeNotFoundException ex) {
        log.error("Action.handleNotFoundException.error not found exception: {}", ex.toString());
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmployeeAlreadyExist.class)
    public ExceptionResponse handleAlreadyExistException(EmployeeAlreadyExist ex) {
        log.error("Action.handleAlreadyExistException.error already exists exception: {}", ex.toString());
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongEmailException.class)
    public ExceptionResponse handleWrongEmailException(WrongEmailException ex) {
        log.error("Action.handleWrongEmailException.error wrong email exception: {}", ex.toString());
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPasswordException.class)
    public ExceptionResponse handleWrongPasswordException(WrongPasswordException ex) {
        log.error("Action.handleWrongPasswordException.error wrong password exception: {}", ex.toString());
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }
}
