package hh.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long>{
    List<Album> findByGenreName(String name);
}
