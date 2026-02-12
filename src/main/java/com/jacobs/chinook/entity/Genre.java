package com.jacobs.chinook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Genre {
    @Id
    @Column(name = "GenreId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull    // lombok, used for RequiredArgsConstructor
    @NotNull    // persistence, used for @Valid on vars in a method field
    @Column(name = "Name", nullable = false)
    private String name;

}
