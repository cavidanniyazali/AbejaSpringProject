package tr.com.abeja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.abeja.entity.Employee;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
    @Modifying
    @Query(value =
            "UPDATE Employee e SET e.email = :email, e.password = :password, e.name = :name, e.surname = :surname WHERE e.id = :id")
    void updateEmployeeById(@Param("id") Integer id,
                            @Param("email") String email,
                            @Param("password") String password,
                            @Param("name") String name,
                            @Param("surname") String surname);
}
