package rs.ac.singidunum.pj;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.pj.entity.Album;
import rs.ac.singidunum.pj.repo.AlbumRepository;


import java.util.List;

@RestController
@RequestMapping(path = "/api/album")
@RequiredArgsConstructor
public class AlbumControler {
    private final AlbumRepository repository;
    @GetMapping
    public List<Album> getAlbum(){
        return repository.findAll();
    }
}
