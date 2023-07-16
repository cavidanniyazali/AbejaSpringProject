package tr.com.abeja.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producttype")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "IDUSERINSERT", nullable = false)
    private int idUserInsert;
    @Column(name = "INSERTDATE", nullable = false)
    private LocalDateTime insertDate;
    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "IDINTG")
    private String idIntG;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
}
