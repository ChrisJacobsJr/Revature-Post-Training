package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceId")
    private Integer id;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @NonNull
    @NotNull
    @Column(name = "InvoiceDate", nullable = false)
    private LocalDateTime invoiceDate;

    @Size(max = 70)
    @Column(name = "BillingAddress")
    private String billingAddress;

    @Size(max = 40)
    @Column(name = "BillingCity")
    private String billingCity;

    @Size(max = 40)
    @Column(name = "BillingState")
    private String billingState;

    @Size(max = 40)
    @Column(name = "BillingCountry")
    private String billingCountry;

    @Size(max = 10)
    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @NonNull
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @DecimalMin("0.00")
    @Column(name = "Total", nullable = false)
    private BigDecimal total;



}
