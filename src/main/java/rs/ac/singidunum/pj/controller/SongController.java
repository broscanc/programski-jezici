package rs.ac.singidunum.pj.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Genre;
import rs.ac.singidunum.pj.entity.Singer;
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
        song.setEditedAt(LocalDateTime.now());

        return repository.save(song);
    }

    @PutMapping(path = "/{id}/info")
    public Song updateSongInfo(@PathVariable Integer id, @RequestBody Song entity) {
        Song song = repository.findOneBySongIdAndDeletedAtIsNull(id).orElseThrow();

        Singer singer = entity.getSingers().get(0);
        Genre genre = entity.getGenres().get(0);

        song.setSingers(List.of(singer));
        song.setGenres(List.of(genre));
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