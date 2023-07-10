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
@Table(name = "CreditCardApplication")
public class CreditCardApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "applicationDetailsId", referencedColumnName = "id", nullable = false)
    private ApplicationDetails applicationDetails;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "creditCardTypeId", referencedColumnName = "id", nullable = false)
    private CreditCardType creditCardType;
}
