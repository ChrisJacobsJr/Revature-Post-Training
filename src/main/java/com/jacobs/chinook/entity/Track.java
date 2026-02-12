package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Track {
    @Id
    @Column(name = "TrackId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;

    @NonNull
    @NotNull
    @JoinColumn(name = "MediaTypeId", nullable = false)
    @ManyToOne(optional = false)
    private MediaType mediaType;

    @JoinColumn(name = "GenreId")
    @ManyToOne
    private Genre genre;

    @Column(name = "Composer")
    @Size(min = 1, max = 220)
    private String composer;

    @NonNull
    @NotNull
    @Column(name = "Milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    // BigDecimal better accommodates the database without the risk of floating point/rounding errors
    // that Doubles are prone to
    @NonNull
    @NotNull
    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;
    
}
