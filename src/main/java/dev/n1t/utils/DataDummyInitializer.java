package dev.n1t.utils;

import dev.n1t.model.Stock;
import dev.n1t.repository.StockRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class DataDummyInitializer {

    private final StockRepository stockRepository;
    @Autowired
    public DataDummyInitializer(StockRepository stockRepository){

        this.stockRepository= stockRepository;
        Stock stock = Stock.builder()
                .stockName("testStock")
                .stockPrice(200.00)
                .stockInventory(50000)
                .build();
        Stock savedStock = stockRepository.save(stock);


    }




}
