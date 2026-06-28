
package rs.ac.singidunum.pj.controller;



import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Singer;
import rs.ac.singidunum.pj.repo.SingerRepository;

@RestController
@RequestMapping("/api/singer")
@RequiredArgsConstructor
public class SingerController {

    private final SingerRepository repository;

    @GetMapping
    public Iterable<Singer> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Singer getOne(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Singer create(@RequestBody Singer singer) {
        return repository.save(singer);
    }

    @PutMapping("/{id}")
    public Singer update(@PathVariable Integer id, @RequestBody Singer entity) {
        Singer singer = repository.findById(id).orElseThrow();
        singer.setName(entity.getName());
        return repository.save(singer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}