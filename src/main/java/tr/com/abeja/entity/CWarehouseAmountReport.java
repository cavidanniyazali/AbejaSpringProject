package tr.com.abeja.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class CWarehouseAmountReport {
    @Id
    private Integer idProduct;
    private String productCode;
    private String productName;
    private Integer idWarehouse;
    private String warehouseName;
    private BigDecimal currentAmount;
    private Integer idProductType;
}
