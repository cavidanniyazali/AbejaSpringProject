package tr.com.abeja.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeemovement")
@Entity
public class EmployeeMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ENTERDATE", nullable = false)
    private LocalDateTime enterDate;

    @Column(name = "EXITDATE")
    private LocalDateTime exitDate;

    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;

    @ManyToOne
    @JoinColumn(name = "IDEMPLOYEE", nullable = false)
    private Employee employee;

    public EmployeeMovement(LocalDateTime enterDate, int isActive, Employee employee) {
        this.enterDate = enterDate;
        this.isActive = isActive;
        this.employee = employee;
    }
}
