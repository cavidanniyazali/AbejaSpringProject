package tr.com.abeja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private String email;
    private String name;
    private String surname;
    private String password;
}
