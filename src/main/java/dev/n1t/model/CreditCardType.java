package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CreditCardType")
public class CreditCardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @Column(nullable = false, name = "rewardsName")
    private String rewardsName;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, name = "interestRate")
    private double interestRate;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, name = "minimumPayment")
    private double minimumPayment;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(nullable = false, name = "creditLimit")
    private double creditLimit;
}
