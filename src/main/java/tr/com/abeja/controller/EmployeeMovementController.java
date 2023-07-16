package tr.com.abeja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.com.abeja.service.EmployeeMovementService;

@RestController
@RequestMapping("/employeeMovement")
public class EmployeeMovementController {
    private final EmployeeMovementService employeeMovementService;

    public EmployeeMovementController(EmployeeMovementService employeeMovementService) {
        this.employeeMovementService = employeeMovementService;
    }

    @PostMapping("/entry")
    @ResponseStatus(HttpStatus.OK)
    public void processCardEntry(@RequestParam("employeeId") Integer employeeId) {
        employeeMovementService.processCardEntry(employeeId);
    }

    @PostMapping("/exit")
    @ResponseStatus(HttpStatus.OK)
    public void processCardExit(@RequestParam("employeeId") Integer employeeId) {
        employeeMovementService.processCardExit(employeeId);
    }
}
