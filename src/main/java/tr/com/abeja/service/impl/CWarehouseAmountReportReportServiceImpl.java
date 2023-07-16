package tr.com.abeja.service.impl;

import org.springframework.stereotype.Service;
import tr.com.abeja.entity.CWarehouseAmountReport;
import tr.com.abeja.repository.CWarehouseAmountReportRepository;
import tr.com.abeja.service.CWarehouseAmountReportService;

@Service
public class CWarehouseAmountReportReportServiceImpl implements CWarehouseAmountReportService {
    private final CWarehouseAmountReportRepository cWarehouseAmountReportRepository;

    public CWarehouseAmountReportReportServiceImpl(CWarehouseAmountReportRepository CWarehouseAmountReportRepository) {
        this.cWarehouseAmountReportRepository = CWarehouseAmountReportRepository;
    }

    @Override
    public CWarehouseAmountReport getCurrentWarehouseAmountReports(Integer idWarehouse,
                                                                   Integer idProduct,
                                                                   Integer idProductGroup1,
                                                                   Integer idProductGroup2,
                                                                   Integer idProductGroup3,
                                                                   Integer idProductType) {
        return cWarehouseAmountReportRepository.getCurrentWarehouseAmountReports(idWarehouse, idProduct,
                idProductGroup1, idProductGroup2, idProductGroup3, idProductType);
    }
}

