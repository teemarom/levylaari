package hh.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.domain.Genre;
import hh.backend.domain.GenreRepository;

@Controller
public class GenreController {

    // annotaatio injektio
    private final GenreRepository genreRepository;

    //konstruktori-injektio
    GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    
    // add genre
    @GetMapping("/addgenre")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        model.addAttribute("genres", genreRepository.findAll());
        return "addgenre"; // addgenre.html
    }

    // save genre
    @PostMapping("/savegenre")
    public String saveGenre(Genre genre) {
        genreRepository.save(genre);
        return "redirect:addgenre"; // addgenre.html
    }

    // delete genre
    @GetMapping("/deletegenre/{genreId}")
    public String deleteGenre(@PathVariable("genreId") Long genreId, Model model) {
        genreRepository.deleteById(genreId);
        return "redirect:../addgenre"; //addgenre.html
    }

    // edit genre
    @GetMapping("/editgenre/{genreId}")
    public String editGenre(@PathVariable("genreId") Long genreId, Model model) {
        Genre genre = genreRepository.findById(genreId).get();
        model.addAttribute("genre", genre);
        return "editgenre"; // editgenre.html
    }
}
