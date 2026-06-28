package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.pj.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}