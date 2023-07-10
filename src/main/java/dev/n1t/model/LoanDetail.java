package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LoanDetail")
public class LoanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(nullable = false, name = "accountId", referencedColumnName = "id")
    private Account account;

    @NotNull
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    @Column(nullable = false, name = "interestRate")
    private double interestRate;

    @NotNull
    @DecimalMin(value = "0.0")
    @Column(nullable = false, name = "minimumPayment")
    private double minimumPayment;

    @NotNull
    @DecimalMin(value = "0.0")
    @Column(nullable = false, name = "initialLoanAmount")
    private double initialLoanAmount;
}
