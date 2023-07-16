package tr.com.abeja.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EXITDATE")
    private LocalDateTime exitDate;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "ENTERDATE", nullable = false)
    private LocalDateTime enterDate;

    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SURNAME")
    private String surname;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeMovement> employeeMovements;

    public Employee(String email, LocalDateTime enterDate, int isActive, String name, String password, String surname) {
        this.email = email;
        this.enterDate = enterDate;
        this.isActive = isActive;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }
}
