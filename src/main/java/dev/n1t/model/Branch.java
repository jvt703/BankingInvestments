package dev.n1t.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "addressId", referencedColumnName = "id")
    private Address address;

    @NotNull
    @Pattern(regexp = "\\d{9}", message = "Invalid phone number format. Use ##########.")
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @NotNull
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters.")
    @Column(nullable = false)
    private String name;
}
