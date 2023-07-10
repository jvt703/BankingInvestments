package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "investingAccountId", nullable = false, referencedColumnName = "id")
    private InvestingAccount investingAccount;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "stockId", nullable = false, referencedColumnName = "id")
    private Stock stock;

    @NotNull
    @PositiveOrZero
    @Column(name = "stockAmount", nullable = false)
    private Integer stockAmount;
}
