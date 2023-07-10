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
@Table(name = "CreditDetail")
public class CreditDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull()
    @OneToOne()
    @JoinColumn(nullable = false, name = "accountId", referencedColumnName = "id")
    private Account account;

    @NotNull()
    @ManyToOne()
    @JoinColumn(nullable = false, name = "creditCardType", referencedColumnName = "id")
    private CreditCardType creditCardType;

}
