package rs.ac.singidunum.pj.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import rs.ac.singidunum.pj.entity.Album;
;


public interface AlbumRepository extends JpaRepository<Album,Integer> {
    List<Album>findAllByDeletedAtIsNull();
    Optional<Album> findOneByAlbumIdAndDeletedAtIsNull(Integer id);

}
