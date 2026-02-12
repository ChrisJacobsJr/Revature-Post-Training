package com.jacobs.chinook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PlaylistTrack {
    @OneToOne
    @NonNull
    @NotNull
    @JoinColumn(name = "PlaylistId", nullable = false)
    private Playlist playlist;

    @OneToOne
    @NonNull
    @NotNull
    @JoinColumn(name = "TrackId", nullable = false)
    private Track track;
}
