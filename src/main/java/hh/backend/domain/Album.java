package hh.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Album {

    @Id // taulun PK-sarake
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tietokanta generoi uudelle albumille id-arvon
    private Long albumId;
    private String title;
    private String artist;
    private int releaseYear;
    private int trackCount;
    // user owner (AppUser)
    @ManyToOne
    @JsonIgnoreProperties("albums") // estää loputtoman loopin
    @JoinColumn(name="genreId")
    private Genre genre; // genre
    
    // konstruktorit
    public Album() {
    }
    
    
    public Album(String title, String artist, int releaseYear, int trackCount, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.trackCount = trackCount;
        this.genre = genre;
    }

    // getterit
    public Long getAlbumId() {
        return albumId;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getTrackCount() {
        return trackCount;
    }
    public Genre getGenre() {
        return genre;
    }
    // setterit
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // toString
    @Override
    public String toString() {
        return "Album [albumId=" + albumId + ", title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear
                + ", trackCount=" + trackCount + ", Genre=" + genre + "]";
    }

    
}
