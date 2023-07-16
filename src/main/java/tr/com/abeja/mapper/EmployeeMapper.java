package tr.com.abeja.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tr.com.abeja.dto.EmployeeDto;
import tr.com.abeja.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto employeeToEmployeeDto(Employee employee);
    void employeeDtoRequestToInstructor(@MappingTarget Employee employee, EmployeeDto employeeDto);
}
