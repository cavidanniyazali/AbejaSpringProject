package tr.com.abeja.service.impl;

import org.springframework.stereotype.Service;
import tr.com.abeja.consts.Message;
import tr.com.abeja.entity.Employee;
import tr.com.abeja.entity.EmployeeMovement;
import tr.com.abeja.exceptions.exception.EmployeeNotFoundException;
import tr.com.abeja.repository.EmployeeMovementRepository;
import tr.com.abeja.repository.EmployeeRepository;
import tr.com.abeja.service.EmployeeMovementService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class EmployeeMovementServiceImpl implements EmployeeMovementService {
    private final EmployeeMovementRepository employeeMovementRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeMovementServiceImpl(EmployeeMovementRepository employeeMovementRepository, EmployeeRepository employeeRepository) {
        this.employeeMovementRepository = employeeMovementRepository;
        this.employeeRepository = employeeRepository;
    }

    public void processCardEntry(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .filter(e -> e.getIsActive() == 1)
                .orElse(null);

        if (employee != null) {
            List<EmployeeMovement> employeeMovements = Optional.ofNullable(employee.getEmployeeMovements())
                    .orElse(new ArrayList<>());
            EmployeeMovement latestMovement = employeeMovements.stream()
                    .max(Comparator.comparing(EmployeeMovement::getEnterDate))
                    .orElse(null);

            if (latestMovement == null || (latestMovement.getEnterDate() != null && latestMovement.getExitDate() != null)) {
                EmployeeMovement movement = new EmployeeMovement();
                movement.setEnterDate(LocalDateTime.now());
                movement.setIsActive(1);
                movement.setEmployee(employee);
                employeeMovements.add(movement);

                employee.setEmployeeMovements(employeeMovements);
                employeeMovementRepository.save(movement);
            } else {
                latestMovement.setEnterDate(LocalDateTime.now());
                employeeMovementRepository.save(latestMovement);
            }
        } else {
            throw new EmployeeNotFoundException(Message.EMPLOYEE_NOT_FOUND, Message.EMPLOYEE_NOT_FOUND_MSG);
        }
    }

    public void processCardExit(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .filter(e -> e.getIsActive() == 1)
                .orElse(null);

        if (employee != null) {
            List<EmployeeMovement> employeeMovements = Optional.ofNullable(employee.getEmployeeMovements())
                    .orElse(new ArrayList<>());
            EmployeeMovement latestMovement = employeeMovements.stream()
                    .max(Comparator.comparing(EmployeeMovement::getEnterDate))
                    .orElse(null);

                latestMovement.setExitDate(LocalDateTime.now());
                employeeMovementRepository.save(latestMovement);
        } else {
            throw new EmployeeNotFoundException(Message.EMPLOYEE_NOT_FOUND, Message.EMPLOYEE_NOT_FOUND_MSG);
        }
    }
}