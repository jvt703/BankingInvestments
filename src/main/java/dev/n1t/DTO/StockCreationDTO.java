package dev.n1t.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockCreationDTO {


    private String stockName;
    private double stockPrice;
    private int stockInventory;

}
