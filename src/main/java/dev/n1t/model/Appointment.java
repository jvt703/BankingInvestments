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
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne()
    @JoinColumn(nullable = false, name = "userId", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne()
    @JoinColumn(nullable = false, name = "branchId", referencedColumnName = "id")
    private Branch branch;

    @NotNull
    @Column(nullable = false, name = "appointmentDateTime")
    private Long appointmentDateTime;

    @NotNull
    @ManyToOne()
    @JoinColumn(nullable = false, name = "bankerId", referencedColumnName = "id")
    private User banker;

    @NotNull
    @ManyToOne()
    @JoinColumn(nullable = false, name = "serviceTypeId", referencedColumnName = "id")
    private ServiceType serviceType;

    @Column(nullable = false)
    private boolean active;

}