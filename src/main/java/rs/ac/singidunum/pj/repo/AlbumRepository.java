package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
