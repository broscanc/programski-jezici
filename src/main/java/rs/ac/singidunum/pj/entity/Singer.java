package rs.ac.singidunum.pj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "singer")
@NoArgsConstructor
@Getter
@Setter
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "singerId")
    private Integer singerId;

    private String name;
}