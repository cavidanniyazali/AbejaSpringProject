package tr.com.abeja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.abeja.entity.CWarehouseAmountReport;
import tr.com.abeja.service.CWarehouseAmountReportService;

@RestController
@RequestMapping("/api")
public class CWarehouseAmountReportController {
    private final CWarehouseAmountReportService CWarehouseAmountReportService;

    public CWarehouseAmountReportController(CWarehouseAmountReportService CWarehouseAmountReportService) {
        this.CWarehouseAmountReportService = CWarehouseAmountReportService;
    }

    @GetMapping("/currentWarehouseAmountReportByWarehouses")
    public CWarehouseAmountReport currentWarehouseAmountReportByWarehouses(
            @RequestParam(value = "idWarehouse", required = false) Integer idWarehouse,
            @RequestParam(value = "idProduct", required = false) Integer idProduct,
            @RequestParam(value = "idProductGroup1", required = false) Integer idProductGroup1,
            @RequestParam(value = "idProductGroup2", required = false) Integer idProductGroup2,
            @RequestParam(value = "idProductGroup3", required = false) Integer idProductGroup3,
            @RequestParam(value = "idProductType", required = false) Integer idProductType) {
        return CWarehouseAmountReportService.getCurrentWarehouseAmountReports(
                idWarehouse, idProduct, idProductGroup1, idProductGroup2, idProductGroup3, idProductType);
    }
}
