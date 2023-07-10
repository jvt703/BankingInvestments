package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "sourceAccount", referencedColumnName = "id")
    private Account sourceAccount;

    @OneToOne()
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "id")
    private Account destinationAccount;

    @NotNull
    private double amount;

    private long points;

    @NotNull
    private Long date;
}
