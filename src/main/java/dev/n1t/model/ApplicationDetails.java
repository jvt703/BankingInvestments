package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ApplicationDetails")
public class ApplicationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;

    @NotNull
    @Column(nullable = false, name = "socialSecurityNumber")
    private Long socialSecurityNumber;

    @NotNull
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters.")
    @Column(nullable = false, name = "motherMaidenName")
    private String motherMaidenName;

    @NotNull
    @Column(nullable = false, name = "residenceOwnership")
    @Enumerated(value = EnumType.STRING)
    private ResidenceOwnershipStatus residenceOwnershipStatus;

    @Column(name = "housingPayment")
    @PositiveOrZero
    private Double housingPayment;

    @NotNull
    @Column(nullable = false, name = "employmentStatus")
    @Enumerated(value = EnumType.STRING)
    private EmploymentStatus employmentStatus;

    @NotNull
    @Column(nullable = false, name = "grossAnnualIncome")
    @PositiveOrZero
    private Double grossAnnualIncome;

    @Column()
    private Boolean approved;

    @Column(name = "decisionDate")
    private Instant decisionDate;

}
