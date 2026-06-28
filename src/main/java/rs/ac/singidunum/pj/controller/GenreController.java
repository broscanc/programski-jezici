
package rs.ac.singidunum.pj.controller;



import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Genre;
import rs.ac.singidunum.pj.repo.GenreRepository;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreRepository repository;

    @GetMapping
    public Iterable<Genre> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getOne(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return repository.save(genre);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Integer id, @RequestBody Genre entity) {
        Genre genre = repository.findById(id).orElseThrow();
        genre.setName(entity.getName());
        return repository.save(genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}