package tr.com.abeja.service;

import org.springframework.stereotype.Service;
import tr.com.abeja.dto.EmployeeDto;
import tr.com.abeja.dto.LoginDto;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();
    EmployeeDto registerEmployee(EmployeeDto employeeDTO);
    EmployeeDto loginEmployee(LoginDto loginDTO);
    EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto);
    void deleteEmployee(Integer id);
}
