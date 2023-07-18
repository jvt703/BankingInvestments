package dev.n1t.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStockDTO {
    private Long Id;
    private String stockName;

    private Double stockPrice;

    private Integer stockInventory;

}
