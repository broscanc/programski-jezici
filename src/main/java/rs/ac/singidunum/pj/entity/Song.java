package rs.ac.singidunum.pj.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "song")
@NoArgsConstructor
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songId")
    private Integer songId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String lyrics;

    private String poster;

    private LocalTime time;

    private LocalDate date;

    private LocalDateTime deletedAt;

    private LocalDateTime editedAt;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;
}