package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import rs.ac.singidunum.pj.entity.Album;
import rs.ac.singidunum.pj.repo.AlbumRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/album")
@RequiredArgsConstructor
public class AlbumController {

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
        album.setDate(new Date());
        album.setPoster("");
        return repository.save(album);
    }

        @PutMapping(path = "/{id}")
        public Album updateAlbum(@PathVariable Integer id, @RequestBody Album entity) {
            Album album = repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();

            album.setTitle(entity.getTitle());
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