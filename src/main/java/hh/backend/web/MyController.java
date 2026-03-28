package hh.backend.web;

import hh.backend.domain.Album;
import hh.backend.domain.AlbumRepository;
import hh.backend.domain.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    private final GenreRepository genreRepository;
    private final AlbumRepository albumRepository;

    MyController(AlbumRepository albumRepository, GenreRepository genreRepository) {
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
    }

    // index
    @GetMapping
    public String index() {
        return "index"; // index.html
    }

    // log in
    @RequestMapping(value="/login")
    public String login() {
        return "login"; // login.html
    }
    
    // album list
    @GetMapping("/albumlist")
    public String albumList(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "albumlist"; // albumlist.html
    }

    // add album
    @GetMapping("/addalbum")
    public String addBook(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("genres", genreRepository.findAll());
        return "addalbum"; // addAlbum.html
        
    }
}
