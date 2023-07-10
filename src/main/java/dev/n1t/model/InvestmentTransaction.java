package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "InvestmentTransaction")
public class InvestmentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull()
    private Long date;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "investingAccountId", referencedColumnName = "id")
    private InvestingAccount investingAccount;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "stockId", referencedColumnName = "id")
    private Stock stock;

    @Positive(message = "Sold price must be positive")
    @Column(name = "soldPrice", nullable = false)
    private double soldPrice;

    @Positive(message = "Sold inventory must be positive")
    @Column(name = "soldInventory", nullable = false)
    private int soldInventory;
}
