package rs.ac.singidunum.pj;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Album> getAlbum() {
        return repository.findAllByDeletedAtIsNull();
    }

    @GetMapping(path = "/{id}")
    public Album getAlbumById(@PathVariable Integer id) {
        return repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        album.setDeletedAt(null);
        album.setEditedAt(null);
        return repository.save(album);
    }

    @PutMapping(path = "/{id}")
    public Album updateAlbum(@PathVariable Integer id, @RequestBody Album entity) {
        Album album = repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();

        album.setTitle(entity.getTitle());
        album.setPoster(entity.getPoster());
        album.setDate(entity.getDate());
        album.setBend(entity.getBend());
        album.setEditedAt(LocalDateTime.now());

        return repository.save(album);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAlbumById(@PathVariable Integer id) {
        Album album = repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();

        album.setDeletedAt(LocalDateTime.now());

        repository.save(album);
    }
}