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
@Table(name = "LoanApplication")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "applicationDetailsId", referencedColumnName = "id", nullable = false)
    private ApplicationDetails applicationDetails;

    @ManyToOne
    @JoinColumn(name = "debitedAccountId", referencedColumnName = "id", nullable = false)
    private Account debitedAccount;

    @NotNull
    @Positive
    @Column(name = "requestedAmount", nullable = false)
    private double requestedAmount;
}
