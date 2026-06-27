package rs.ac.singidunum.pj.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SongGenreModel {
    private Integer songId;
    private Integer genreId;

    private String genreName;
}