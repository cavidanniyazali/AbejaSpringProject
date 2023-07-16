package tr.com.abeja.service;

public interface EmployeeMovementService {
    void processCardEntry(Integer id);
    void processCardExit(Integer id);
}
