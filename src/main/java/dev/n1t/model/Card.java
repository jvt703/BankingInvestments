package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "accountId", referencedColumnName = "id")
    private Account account;

    @NotNull
    @Column(nullable = false)
    private boolean active;

    @NotNull
    @Digits(integer = 4, fraction = 0, message = "PIN must be a 4 digit number")
    @Column(nullable = false)
    private Integer pin;

    @NotNull
    @Digits(integer = 16, fraction = 0, message = "Card number must be 16 digits")
    @Column(name = "cardNumber", nullable = false)
    private Long cardNumber;
}
