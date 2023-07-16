package tr.com.abeja.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "BARCODE")
    private String barcode;
    @Column(name = "BUYINGPRICE", nullable = false)
    private double buyingPrice;
    @Column(name = "WHOLESALEPRICE", nullable = false)
    private double wholeSalePrice;
    @Column(name = "REATILPRICE", nullable = false)
    private double retailPrice;
    @Column(name = "CODE")
    private String code;
    @Column(name = "PRODUCTCODE")
    private String productCode;
    @Column(name = "IDUSERINSERT", nullable = false)
    private int idUserInsert;
    @Column(name = "IMAGEPATH")
    private String imagePath;
    @Column(name = "INSERTDATE", nullable = false)
    private LocalDateTime insertDate;
    @Column(name = "ISACTIVE", nullable = false)
    private int isActive;
    @Column(name = "MAXLIMIT")
    private double maxLimit;
    @Column(name = "MINLIMIT")
    private double minLimit;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "PRICE", nullable = false)
    protected double price;
    @Column(name = "NAVGPRICE")
    protected double avgPrice;
    @Column(name = "PRODUCTDISCOUNT")
    private double productDiscount;
    @Column(name = "PRODUCTSERVICEORDERING")
    private int productServiceOrdering;
    @Column(name = "VATINCLUDED", nullable = false)
    private int vatIncluded;
    @Column(name = "IDCURRENCY", nullable = false)
    private int idCurrency;
    @Column(name = "IDPRODUCTDETAIL")
    private int idProductDetail;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCTTYPE",nullable = false)
    private ProductType productType;
    @Column(name = "IDTEXTTEMPLATE")
    private int idTaxTemplate;
    @Column(name = "IDPRINTERGROUP")
    private int idPrinterGroup;
    @Column(name = "IDINTG")
    private String idIntG;
    @Column(name = "SCALESPRODUCT")
    private int scalesProduct;
    @Column(name = "DOUBLECOST")
    private double doubleCost;
    @Column(name = "GLOBALCOST")
    private double gobletCost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDWAREHOUSE")
    private Warehouse warehouse;
    @Column(name = "YSPRODUCT")
    private int ysProduct;
    @Column(name = "GTPRODUCT")
    private int gtProduct;
    @Column(name = "ISPRODUCTGROUP1")
    private int idProductGroup1;
    @Column(name = "ISPRODUCTGROUP2")
    private int idProductGroup2;
    @Column(name = "ISPRODUCTGROUP3")
    private int idProductGroup3;
    @Column(name = "ISBONUSPRODUCTGROUP")
    private int idBonusProductGroup;
    @Column(name = "ISPROMOTIONPRODUCTGROUP")
    private int idPromotionProductGroup;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WarehouseAmount> warehouseAmounts = new ArrayList<>();


}
