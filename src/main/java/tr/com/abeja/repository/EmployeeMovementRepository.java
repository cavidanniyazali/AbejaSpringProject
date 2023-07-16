package tr.com.abeja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.abeja.entity.EmployeeMovement;

@Repository
public interface EmployeeMovementRepository extends JpaRepository<EmployeeMovement, Integer> {
}
