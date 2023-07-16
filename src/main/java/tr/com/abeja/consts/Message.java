package tr.com.abeja.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Message {
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String EMPLOYEE_NOT_FOUND_MSG = "Provided employee not found";
    public static final String EMPLOYEE_ALREADY_EXIST = "Employee already exist";
    public static final String EMPLOYEE_ALREADY_EXIST_MSG = "Provided employee already exists";
    public static final String WRONG_EMAIL = "Wrong email";
    public static final String WRONG_EMAIL_MSG = "Provided email is wrong";
    public static final String WRONG_PASSWORD = "Wrong email";
    public static final String WRONG_PASSWORD_MSG = "Provided password is wrong";
}
