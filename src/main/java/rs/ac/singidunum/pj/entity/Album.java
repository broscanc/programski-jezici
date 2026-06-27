package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name="album")
@NoArgsConstructor
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "albumId")
    private Integer albumId;

    private String title;
    private String poster;
    private Date date;
    private String bend;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;
    @Column(name = "editedAt")
    private LocalDateTime editedAt;
}