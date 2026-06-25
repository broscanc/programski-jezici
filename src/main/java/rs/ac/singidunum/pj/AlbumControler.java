package rs.ac.singidunum.pj;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.pj.entity.Album;
import rs.ac.singidunum.pj.repo.AlbumRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/album")
@RequiredArgsConstructor
public class AlbumControler {
    private final AlbumRepository repository;
    @GetMapping
    public List<Album> getAlbum(){
        return repository.findAllByDeletedAtIsNull();
    }
    @DeleteMapping(path = "/{id}")
    public void deleteALbumById(@PathVariable Integer id ){
        Album album=repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();
        album.setDeletedAt(LocalDateTime.now());
        repository.save(album);
    }
}
