package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "User")
public class AppUser {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @NotNull
    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @NonNull
    @NotNull
    @Column(name = "Password", nullable = false)
    private String password;

    @NonNull
    @NotNull
    @Column(name = "Role", nullable = false)
    private String role;

    @OneToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
    private Employee employee;

}
