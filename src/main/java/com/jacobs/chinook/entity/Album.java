package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Album {
    @Id
    @Column(name = "AlbumId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotNull
    @Column(name = "Title", nullable = false)
    private String title;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;

}
