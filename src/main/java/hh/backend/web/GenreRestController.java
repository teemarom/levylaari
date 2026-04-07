package hh.backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.backend.domain.Genre;
import hh.backend.domain.GenreRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class GenreRestController {

    // konstruktori injektio
    private final GenreRepository genreRepository;

    public GenreRestController (GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/addgenre")
    public @ResponseBody List<Genre> findAllGenresRest() {
        return (List<Genre>) genreRepository.findAll();
    }

    @GetMapping("/addgenre/{genreId}")
    public @ResponseBody Optional<Genre> getOneGenreRest (@PathVariable(name="genreId") Long genreId) {
        return genreRepository.findById(genreId);
    }

    @PostMapping(value="/addgenre")
    public @ResponseBody Genre saveGenreRest(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    } 
}
