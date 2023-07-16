package tr.com.abeja.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "IDUSERINSERT", nullable = false)
    private int idUserInsert;
    @Column(name = "INSERTDATE", nullable = false)
    private LocalDateTime insertDate;
    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;
    @Column(name = "NAME", nullable = false)
    private String name;
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WarehouseAmount> warehouseAmounts = new ArrayList<>();

}
