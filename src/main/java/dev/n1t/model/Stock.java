package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stockName", nullable = false)
    private String stockName;

    @Positive
    @Column(name = "stockPrice", nullable = false)
    private double stockPrice;

    @PositiveOrZero
    @Column(name = "stockInventory", nullable = false)
    private int stockInventory;
}
