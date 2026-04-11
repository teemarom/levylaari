package hh.backend.web;

import hh.backend.domain.Album;
import hh.backend.domain.AlbumRepository;

import hh.backend.domain.GenreRepository;
import jakarta.validation.Valid;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    // annotaatio injektio
    private final GenreRepository genreRepository;
    private final AlbumRepository albumRepository;

    // konstruktori-injektio
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
    @RequestMapping(value = "/login")
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
        return "addalbum"; // addalbum.htm
    }

    // save album
    @PostMapping("/save")
    public String save(@Valid Album album, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreRepository.findAll());
            return "addalbum";
        }
        albumRepository.save(album);
        return "redirect:albumlist";
    }

    // delete album
    @GetMapping("/delete/{albumId}")
    public String delete(@PathVariable("albumId") Long albumId, Model model) {
        albumRepository.deleteById(albumId);
        return "redirect:../albumlist";
    }

    // edit album
    @GetMapping("/edit/{albumId}")
    public String editAlbum(@PathVariable("albumId") Long albumId, Model model) {
        Album album = albumRepository.findById(albumId).get();
        model.addAttribute("album", album);
        model.addAttribute("genres", genreRepository.findAll());
        return "editalbum"; // editalbum.html
    }

    // genre albums list
    @GetMapping("/albums")
    public String listAlbums(@RequestParam(required = false) String genre, Model model) {

        List<Album> albums;

        if (genre != null && !genre.isEmpty()) {
            albums = albumRepository.findByGenre_GenreName(genre);
        } else {
            albums = albumRepository.findAll();
        }
        model.addAttribute("albums", albums);
        model.addAttribute("selectedGenre", genre);
        return "albums";
    }

}
