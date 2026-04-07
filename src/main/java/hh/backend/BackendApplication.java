package hh.backend;

import hh.backend.domain.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hh.backend.domain.Album;
import hh.backend.domain.AlbumRepository;
import hh.backend.domain.AppUser;
import hh.backend.domain.Genre;
import hh.backend.domain.GenreRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@SpringBootApplication
public class BackendApplication {

	private final AppUserRepository appUserRepository;
    private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

    BackendApplication(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    } 

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAlbumRows(AlbumRepository albumRepository, GenreRepository genreRepository) {

		return (args) -> {

			// Genrejen lisäys tietokantaan
			log.info("Add genre");
			Genre unknown = genreRepository.save(new Genre("Unknown"));
			Genre pop = genreRepository.save(new Genre("Pop"));
			Genre rap = genreRepository.save(new Genre("Rap"));
			Genre metal = genreRepository.save(new Genre("Metal"));

			// Genrejen testitulostus
			log.info("Print all Genres");
			for (Genre genre : genreRepository.findAll()) {
				log.info(genre.toString());
			}
			
			// albumien lisäys tietokantaan
			albumRepository.save(new Album(
				"Kroketti",
				"Ultra Bra",
				1997,
				13,
				pop
			));

			albumRepository.save(new Album(
				"Luopioisten Luja",
				"Tykopaatti",
				2008,
				15,
				rap
			));

			albumRepository.save(new Album(
				"Master of Reality",
				"Black Sabbath",
				1971,
				8,
				metal
			));

			// Albumien testitulostus
			log.info("Print all Albums");
			for (Album album : albumRepository.findAll()) {
				log.info(album.toString());
			}
			log.info("Homma pyörii");

			AppUser user2 = new AppUser(
				"admin",
				"$2a$12$HI1OU4UMny7Di4lcUxFoy.4j9EoRRKgRLpAGT2/EG7u1gxNP681wu",
				"ADMIN");

			appUserRepository.save(user2);

		};
	}
	

}
