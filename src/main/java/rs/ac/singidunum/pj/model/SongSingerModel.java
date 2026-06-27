package rs.ac.singidunum.pj.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SongSingerModel {
    private Integer songId;
    private Integer singerId;

    private String singerName;
}