package hh.backend;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.thymeleaf.standard.expression.BooleanTokenExpression;

import hh.backend.domain.Album;
import hh.backend.domain.AlbumRepository;

@DataJpaTest
public class AlbumRepositoryTest {


    @Autowired
    private AlbumRepository albumRepository;

    @Test // search
    public void findByTitle() {
        Album album = new Album(
            "Kroketti",
            "Ultra Bra",
            1997,
            13,
            null
        );
        List<Album> albums = albumRepository.findByTitle("Kroketti") ;
        assertThat(albums).hasSize(1);
        assertThat(albums.get(0).getArtist()).isEqualTo("Ultra Bra");
    }

    @Test // save
    public void saveAlbum() {
        Album album = new Album(
            "Testilevy",
            "Testiartisti",
            2000,
            10,
            null
        );
        albumRepository.save(album);

        List<Album> albums = albumRepository.findByTitle("Testilevy");
        assertThat(albums.get(0).getArtist()).isEqualTo("Testiartisti");
    }

    @Test // delete
    public void deleteAlbum() {
         Album album = new Album(
            "Testilevy",
            "Testiartisti",
            2000,
            10,
            null
        );
        albumRepository.save(album);
        Long id = album.getAlbumId();

        albumRepository.deleteById(id);
        assertThat(albumRepository.findById(id)).isEmpty();
    }
}
