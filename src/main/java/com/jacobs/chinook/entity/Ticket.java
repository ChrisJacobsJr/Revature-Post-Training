package com.jacobs.chinook.entity;

import com.jacobs.chinook.utils.TicketStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "\"Ticket\"")
public class Ticket {
    @Id
    @Column(name = "TicketId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId", nullable = false)
    private Customer customer;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId", nullable = false)
    private Employee employee;

    // dropping Lombok @NonNull because it has a default
    @NotNull
    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.OPEN;

    // dropping Lombok @NonNull because it has a default
    // dropping Validations @NonNull because primitive booleans can't be null
    @Column(name = "Resolved",  nullable = false)
    private boolean resolved = false;

}
