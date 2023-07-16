package tr.com.abeja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.abeja.entity.CWarehouseAmountReport;

@Repository
public interface CWarehouseAmountReportRepository extends JpaRepository<CWarehouseAmountReport, Integer> {
    @Query(value = "SELECT p.ID AS idProduct, p.PRODUCTCODE AS productCode, p.NAME AS productName, " +
            "w.ID AS idWarehouse, w.NAME AS warehouseName, wa.AMOUNT AS currentAmount, " +
            "pt.ID AS idProductType " +
            "FROM warehouse_amount wa " +
            "JOIN product p ON wa.IDPRODUCT = p.ID " +
            "JOIN warehouse w ON wa.IDWAREHOUSE = w.ID " +
            "JOIN producttype pt ON p.IDPRODUCTTYPE = pt.ID " +
            "WHERE (:idWarehouse IS NULL OR w.id = :idWarehouse) " +
            "AND (:idProduct IS NULL OR p.ID = :idProduct) " +
            "AND (:idProductGroup1 IS NULL OR p.ISPRODUCTGROUP1 = :idProductGroup1) " +
            "AND (:idProductGroup2 IS NULL OR p.ISPRODUCTGROUP2 = :idProductGroup2) " +
            "AND (:idProductGroup3 IS NULL OR p.ISPRODUCTGROUP3 = :idProductGroup3) " +
            "AND (:idProductType IS NULL OR pt.ID = :idProductType)",
            nativeQuery = true)
    CWarehouseAmountReport getCurrentWarehouseAmountReports(
            @Param("idWarehouse") Integer idWarehouse,
            @Param("idProduct") Integer idProduct,
            @Param("idProductGroup1") Integer idProductGroup1,
            @Param("idProductGroup2") Integer idProductGroup2,
            @Param("idProductGroup3") Integer idProductGroup3,
            @Param("idProductType") Integer idProductType);
}
