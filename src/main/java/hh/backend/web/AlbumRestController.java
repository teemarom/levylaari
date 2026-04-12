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

import hh.backend.domain.Album;
import hh.backend.domain.AlbumRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class AlbumRestController {

    // konstruktori injektio
    private final AlbumRepository albumRepository;

    public AlbumRestController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albumlist")
    public @ResponseBody List<Album> findAllAlbumsRest() {
        return (List<Album>) albumRepository.findAll();
    }

    @GetMapping("/albumlist/{albumId}")
    public @ResponseBody Optional<Album> getOneAlbumRest(@PathVariable(name = "albumId") Long albumId) {
        return albumRepository.findById(albumId);
    }

    @PostMapping(value="/albumlist")
    public @ResponseBody Album saveAlbumRest(@RequestBody Album album) {
        return albumRepository.save(album);
    }

}
