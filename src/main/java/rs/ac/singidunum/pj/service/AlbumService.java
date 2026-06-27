package rs.ac.singidunum.pj.service;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.pj.entity.Album;
import rs.ac.singidunum.pj.repo.AlbumRepository;

@Service
public class AlbumService {

    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public Iterable<Album> findAll() {
        return repository.findAll();
    }

    public Album findById(Integer id) {
        return repository.findOneByAlbumIdAndDeletedAtIsNull(id).orElseThrow();
    }

    public Album save(Album album) {
        return repository.save(album);
    }

    public void delete(Integer id) {
        Album album = findById(id);
        repository.delete(album);
    }
}