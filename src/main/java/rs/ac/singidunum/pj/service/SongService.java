package rs.ac.singidunum.pj.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.pj.entity.Song;
import rs.ac.singidunum.pj.repo.SongRepository;

@Service
public class SongService {

    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public Iterable<Song> findAll() {
        return repository.findAll();
    }

    public Song findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Song save(Song song) {
        return repository.save(song);
    }

    public void delete(Integer id) {
        Song song = findById(id);
        repository.delete(song);
    }
}