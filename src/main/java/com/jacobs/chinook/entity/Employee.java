package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId")
    private Integer id;

    @NonNull
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LastName", nullable = false)
    private String lastName;

    @NonNull
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Size(min = 1, max = 30)
    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ReportsTo")
    private Employee reportsTo;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "HireDate")
    private LocalDateTime hireDate;

    @Size(min = 1, max = 70)
    @Column(name = "Address")
    private String address;

    @Size(min = 1, max = 40)
    @Column(name = "City")
    private String city;

    @Size(min = 1, max = 40)
    @Column(name = "State")
    private String state;

    @Size(min = 1, max = 40)
    @Column(name = "Country")
    private String country;

    @Size(min = 1, max = 10)
    @Column(name = "PostalCode")
    private String postalCode;

    @Size(min = 1, max = 24)
    @Column(name = "Phone")
    private String phoneNumber;

    @Size(min = 1, max = 24)
    @Column(name = "Fax")
    private String faxNumber;

    @Size(min = 1, max = 60)
    @Column(name = "Email")
    private String email;




}
