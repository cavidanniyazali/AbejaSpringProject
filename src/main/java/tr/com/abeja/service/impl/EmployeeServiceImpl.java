package tr.com.abeja.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.abeja.consts.Message;
import tr.com.abeja.dto.EmployeeDto;
import tr.com.abeja.dto.LoginDto;
import tr.com.abeja.entity.Employee;
import tr.com.abeja.entity.EmployeeMovement;
import tr.com.abeja.exceptions.exception.EmployeeAlreadyExist;
import tr.com.abeja.exceptions.exception.EmployeeNotFoundException;
import tr.com.abeja.mapper.EmployeeMapper;
import tr.com.abeja.repository.EmployeeMovementRepository;
import tr.com.abeja.repository.EmployeeRepository;
import tr.com.abeja.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeMapper employeeMapper;
    private final EmployeeMovementRepository employeeMovementRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo, PasswordEncoder passwordEncoder,
                               EmployeeMapper employeeMapper, EmployeeMovementRepository employeeMovementRepository) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
        this.employeeMapper = employeeMapper;
        this.employeeMovementRepository = employeeMovementRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDto registerEmployee(EmployeeDto employeeDTO) {
        String enteredPassword = Optional.ofNullable(employeeDTO.getPassword())
                .map(passwordEncoder::encode)
                .orElse(null);

        Employee employee = new Employee(
                employeeDTO.getEmail(),
                LocalDateTime.now(),
                1,
                employeeDTO.getName(),
                enteredPassword,
                employeeDTO.getSurname()
        );
        employeeRepo.save(employee);
        return employeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto loginEmployee(LoginDto loginDTO) {
        Optional<Employee> employee = Optional
                .ofNullable(employeeRepo.findByEmail(loginDTO.getEmail()))
                .filter(e -> e.getIsActive() == 1);
        employee.filter(e -> loginDTO.getPassword() != null &&
                        passwordEncoder.matches(loginDTO.getPassword(), e.getPassword()))
                .orElse(employee.get());

        return employee.map(employeeMapper::employeeToEmployeeDto).orElseThrow(() -> new EmployeeNotFoundException(Message.EMPLOYEE_NOT_FOUND,
                Message.EMPLOYEE_NOT_FOUND_MSG));
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Optional<Employee> byId = employeeRepo.findById(id);
        Employee employee = byId.orElseThrow(() -> new EmployeeNotFoundException(Message.EMPLOYEE_NOT_FOUND,
                Message.EMPLOYEE_NOT_FOUND_MSG));
        if (employee.getEmail().equals(employeeDto.getEmail())) {
            throw new EmployeeAlreadyExist(Message.EMPLOYEE_ALREADY_EXIST, Message.EMPLOYEE_ALREADY_EXIST_MSG);
        }
        String encodedPassword = passwordEncoder.encode(employeeDto.getPassword());
        employeeDto.setPassword(encodedPassword);
        employeeMapper.employeeDtoRequestToInstructor(employee, employeeDto);
        employeeRepo.updateEmployeeById(employee.getId(), employee.getEmail(), employee.getPassword(),
                employee.getName(), employee.getSurname());
        return employeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Optional<Employee> byId = employeeRepo.findById(id);
        Employee employee = byId.orElseThrow(() -> new EmployeeNotFoundException(Message.EMPLOYEE_NOT_FOUND,
                Message.EMPLOYEE_NOT_FOUND_MSG));
        employee.setIsActive(0);
        employeeRepo.save(employee);

        List<EmployeeMovement> employeeMovements = employeeMovementRepository.findAll();
        List<EmployeeMovement> movements = employeeMovements.stream()
                .filter(e -> e.getEmployee().equals(employee)).collect(Collectors.toList());
        movements.forEach(e -> e.setIsActive(0));
        employeeMovementRepository.saveAll(movements);
    }
}