package tr.com.abeja.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse_amount")
public class WarehouseAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;
    @Column(name = "INSERTDATE", nullable = false)
    private LocalDateTime insertDate;
    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCT")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDWAREHOUSE")
    private Warehouse warehouse;
    @Column(name = "UPDATEDATE")
    private LocalDateTime updateDate;
}
