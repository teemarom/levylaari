package hh.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // tietokannan taulun määrittely
public class Genre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // tietokanta generoi uudelle genrelle id-arvon
    private Long genreId;
    private String genreName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    @JsonIgnore // estää loputtoman loopin
    private List<Album> albums;
    
   

    // konstruktorit
    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    // getterit
    public Long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    @OneToMany
    public List<Album> getAlbums() {
        return albums;
    }

    // setterit
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    // toString
    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
    }

}
