package tr.com.abeja.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.com.abeja.dto.EmployeeDto;
import tr.com.abeja.dto.LoginDto;
import tr.com.abeja.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAll() {
        log.info("Get all employees");
        return employeeService.findAllEmployees();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto registerEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("Registered employee");
        return employeeService.registerEmployee(employeeDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto loginEmployee(@RequestBody LoginDto loginDto) {
        log.info("Login employee");
        return employeeService.loginEmployee(loginDto);
    }

    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto updateUser(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        log.info("updated employee with id");
        return employeeService.updateEmployee(id, employeeDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable Integer id) {
        log.info("deleted employee with id");
        employeeService.deleteEmployee(id);
    }
}
