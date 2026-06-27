package rs.ac.singidunum.pj.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import rs.ac.singidunum.pj.entity.Song;


public interface SongRepository extends JpaRepository<Song, Integer> {

    List<Song> findAllByDeletedAtIsNull();

    Optional<Song> findOneBySongIdAndDeletedAtIsNull(Integer songId);

}