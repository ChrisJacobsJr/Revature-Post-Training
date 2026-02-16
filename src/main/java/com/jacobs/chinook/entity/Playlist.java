package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Playlist {
    @Id
    @Column(name = "PlaylistId")
    private Integer id;

    @NonNull
    @NotNull
    @Column(name = "Name")
    private String name;
}
