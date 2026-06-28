package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.pj.entity.Singer;

public interface SingerRepository extends JpaRepository<Singer, Integer> {

}