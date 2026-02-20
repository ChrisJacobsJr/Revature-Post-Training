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
public class Album {
    @Id
    @Column(name = "AlbumId")
    private Integer id;

    @NonNull
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "Title", nullable = false)
    private String title;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;

}
