package dev.n1t.DTO;

import dev.n1t.model.Stock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutgoingStockDTO {

    private long id;
    private String stockName;
    private double stockPrice;
    private int stockInventory;

    public OutgoingStockDTO(Stock stock){

        this.id= stock.getId();
        this.stockName= stock.getStockName();
        this.stockPrice = stock.getStockPrice();
        this.stockInventory = stock.getStockInventory();

    };


}
