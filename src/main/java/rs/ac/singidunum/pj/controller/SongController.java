package rs.ac.singidunum.pj.controller;

import java.time.LocalDateTime;


import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Song;
import rs.ac.singidunum.pj.repo.SongRepository;

@RestController
@RequestMapping(path = "/api/song")
@RequiredArgsConstructor
public class SongController {

    private final SongRepository repository;

    @GetMapping
    public Iterable<Song> getSongs() {
        return repository.findAllByDeletedAtIsNull();
    }

    @GetMapping(path = "/{id}")
    public Song getSong(@PathVariable Integer id) {
        return repository.findOneBySongIdAndDeletedAtIsNull(id).orElseThrow();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        song.setDeletedAt(null);
        song.setEditedAt(null);

        return repository.save(song);
    }

    @PutMapping(path = "/{id}")
    public Song updateSong(@PathVariable Integer id, @RequestBody Song entity) {
        Song song = repository.findOneBySongIdAndDeletedAtIsNull(id).orElseThrow();

        song.setTitle(entity.getTitle());
        song.setLyrics(entity.getLyrics());
        song.setPoster(entity.getPoster());
        song.setTime(entity.getTime());
        song.setDate(entity.getDate());
        song.setAlbum(entity.getAlbum());
        song.setEditedAt(LocalDateTime.now());

        return repository.save(song);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSong(@PathVariable Integer id) {
        Song song = repository.findOneBySongIdAndDeletedAtIsNull(id).orElseThrow();
        song.setDeletedAt(LocalDateTime.now());
        repository.save(song);
    }
}