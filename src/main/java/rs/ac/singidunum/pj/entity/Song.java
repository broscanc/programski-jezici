package rs.ac.singidunum.pj.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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

    @ManyToMany
    @JoinTable(name = "songSinger",joinColumns = @JoinColumn(name = "songId"),
    inverseJoinColumns = @JoinColumn(name = "singerId"))
    private List<Singer> singers;

    @ManyToMany
@JoinTable(name = "songGenre",joinColumns = @JoinColumn(name = "songId"),inverseJoinColumns = @JoinColumn(name = "genreId"))
private List<Genre> genres;

}