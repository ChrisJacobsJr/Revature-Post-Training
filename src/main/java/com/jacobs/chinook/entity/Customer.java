package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @Column(name = "CustomerId")
    private Integer id;

    @NonNull
    @NotNull
    @Size(max = 40)
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @NonNull
    @NotNull
    @Size(max = 20)
    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Size(max = 80)
    @Column(name = "Company")
    private String company;

    @Size(max = 70)
    @Column(name = "Address")
    private String address;

    @Size(max = 40)
    @Column(name = "City")
    private String city;

    @Size(max = 40)
    @Column(name = "State")
    private String state;

    @Size(max = 40)
    @Column(name = "Country")
    private String country;

    @Size(max = 10)
    @Column(name = "PostalCode")
    private String postalCode;

    @Size(max = 24)
    @Column(name = "Phone")
    private String phone;

    @Size(max = 24)
    @Column(name = "Fax")
    private String fax;

    @Email
    @Size(max = 60)
    @Column(name = "Email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "SupportRepId")
    private Employee supportRep;




}
