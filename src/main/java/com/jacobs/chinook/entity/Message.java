package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "\"Message\"")
public class Message {
    @Id
    @Column(name = "MessageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "TicketId",  nullable = false)
    private Ticket ticket;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "SenderId", nullable = false)
    private AppUser sender;
    
    @NonNull
    @NotNull
    @Column(name = "Text")
    private String text;

}
