package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Artist {
    @Id
    @Column(name = "ArtistId")
    private Integer id;

    @NonNull
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Name", nullable = false)
    private String name;
}
