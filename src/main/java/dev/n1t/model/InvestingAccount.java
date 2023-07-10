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
@Table(name = "InvestingAccount")
public class InvestingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "userId", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, name = "investmentBalance")
    @NotNull()
    @Positive()
    private double investmentBalance;
}
