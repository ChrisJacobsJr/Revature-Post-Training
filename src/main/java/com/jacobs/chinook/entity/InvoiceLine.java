package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class InvoiceLine {
    @Id
    @Column(name = "InvoiceLineId")
    private Integer id;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "InvoiceId", nullable = false)
    private Invoice invoice;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "TrackId", nullable = false)
    private Track track;

    @NonNull
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @DecimalMin("0.00")
    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @NonNull
    @NotNull
    @Min(0)
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;
}
