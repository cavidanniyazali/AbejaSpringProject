package tr.com.abeja.service;

import org.springframework.stereotype.Service;
import tr.com.abeja.entity.CWarehouseAmountReport;

@Service
public interface CWarehouseAmountReportService {
    CWarehouseAmountReport getCurrentWarehouseAmountReports(Integer idWarehouse, Integer idProduct,
                                                               Integer idProductGroup1, Integer idProductGroup2,
                                                               Integer idProductGroup3, Integer idProductType);
}
