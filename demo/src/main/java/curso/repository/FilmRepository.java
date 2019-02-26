package curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
	List<Film> findByTitleStartingWith(String tittle);
	List<Film> findTop5ByTitleStartingWith(String tittle);

}
