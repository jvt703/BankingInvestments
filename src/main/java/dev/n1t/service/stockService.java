package dev.n1t.service;

import dev.n1t.DTO.*;
import dev.n1t.exception.StockNotFoundException;
import dev.n1t.model.Account;
import dev.n1t.model.Stock;
import dev.n1t.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class stockService {

    private final StockRepository StockRepository;


    @Autowired
    public stockService(StockRepository stockRepository){
        this.StockRepository = stockRepository;
    };



    public OutgoingStockDTO getStock(StockIdRequest stockIdRequest){
        Stock stock = StockRepository.findById(stockIdRequest.getId())
                .orElseThrow(() -> new StockNotFoundException(stockIdRequest.getId()));
                ;
        return new OutgoingStockDTO(stock);
    };


    public List<OutgoingStockDTO> getAllStocks(Map<String, String> queryParams) {
        Long id = null;
        String stockName = null;
        Double stockPrice = null;

        if (queryParams.containsKey("id")) {
            id = Long.parseLong(queryParams.get("id"));
        }

        if (queryParams.containsKey("stockName")) {
            stockName = queryParams.get("stockName");
        }

        if (queryParams.containsKey("lastName")) {
            stockPrice = Double.parseDouble(queryParams.get("stockPrice"));
        }


        List<Stock> Stocks = StockRepository.findAllByQueryParams(
                id,stockName,stockPrice
        );

        return Stocks.stream()
                .map(OutgoingStockDTO::new)
                .collect(Collectors.toList());
    }

    public OutgoingStockDTO CreateStock(StockCreationDTO stockCreationDTO){

        Stock stock = Stock.builder()
                .stockName(stockCreationDTO.getStockName())
                .stockPrice(stockCreationDTO.getStockPrice())
                .stockInventory(stockCreationDTO.getStockInventory())
                .build();
        Stock stockSaved = StockRepository.save(stock);
    return new OutgoingStockDTO(stockSaved);
    };


    public OutgoingStockDTO DeleteStock(StockDeletionDTO stockDeletionDTO){
            Stock stockToDelete = StockRepository.findById(stockDeletionDTO.getId()).orElseThrow(() -> new StockNotFoundException(stockDeletionDTO.getId()));
          StockRepository.delete(stockToDelete);
          return new OutgoingStockDTO(stockToDelete);
    };

    public OutgoingStockDTO UpdateStock(UpdateStockDTO updateStockDTO){
            Stock stock = StockRepository.findById(updateStockDTO.getId()).orElseThrow(() -> new StockNotFoundException(updateStockDTO.getId()));
        if (updateStockDTO.getStockPrice() != null) {
            stock.setStockPrice(updateStockDTO.getStockPrice());
        }
        if (updateStockDTO.getStockInventory() != null) {
            stock.setStockInventory(updateStockDTO.getStockInventory());
        }

        Stock updatedStock = StockRepository.save(stock);

        return new OutgoingStockDTO(updatedStock);


    };

}
