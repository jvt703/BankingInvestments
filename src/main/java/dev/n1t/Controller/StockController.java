package dev.n1t.Controller;

import dev.n1t.DTO.*;
import dev.n1t.service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
public class StockController {

    private final stockService StockService;

    @Autowired
    public StockController(stockService StockService){
        this.StockService = StockService;
    }

    @GetMapping(path= "Stock/{StockId}")
    public OutgoingStockDTO getStockbyId(
            @PathVariable(value = "StockId") long StockId
            ){
        StockIdRequest stockIdRequest = new StockIdRequest(StockId);
        return StockService.getStock(stockIdRequest);
    }

    @GetMapping(path= "Stocks")
    public List<OutgoingStockDTO> getStocksByParams(
            @RequestParam Map<String, String> queryParams,
            @RequestHeader("Role") String Role){
            return StockService.getAllStocks(queryParams);
    }

    @PostMapping("/Stock/create")
    public OutgoingStockDTO createStock(
            @Validated @RequestBody StockCreationDTO stockCreationDTO){

        return StockService.CreateStock(stockCreationDTO);
    }

    @DeleteMapping("Stock/delete")
    public OutgoingStockDTO deleteStock(
            @Validated @RequestBody StockDeletionDTO stockDeletionDTO
            ){
        return StockService.DeleteStock(stockDeletionDTO);
    }

    @PutMapping("Stock/update")
    public OutgoingStockDTO updateStock(
            @Validated @RequestBody UpdateStockDTO updateStockDTO
            ){
        return StockService.UpdateStock(updateStockDTO);
    }


}
