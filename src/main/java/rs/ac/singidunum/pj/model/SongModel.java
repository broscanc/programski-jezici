package rs.ac.singidunum.pj.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SongModel {
    private Integer songId;
    private String title;
    private String lyrics;
    private String poster;
    private LocalTime time;
    private LocalDate date;

    private Integer albumId;

    private LocalDateTime deletedAt;
    private LocalDateTime editedAt;

    private List<SongSingerModel> songSingers;
    private List<SongGenreModel> songGenres;
}