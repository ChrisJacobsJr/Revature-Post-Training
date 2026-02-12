package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PlaylistTrack {

    @EmbeddedId
    private PlaylistTrackId id;

    @ManyToOne
    @MapsId("playlistId")
    @JoinColumn(name = "PlaylistId", nullable = false)
    @NonNull
    @NotNull
    private Playlist playlist;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "TrackId", nullable = false)
    @NonNull
    @NotNull
    private Track track;
}

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class PlaylistTrackId implements Serializable {
    private Integer playlistId;
    private Integer trackId;
}
