package hh.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AlbumRepository extends JpaRepository<Album, Long>{
    List<Album> findByTitle(String title);
    List<Album> findByGenre_GenreName(String genreName);
}
