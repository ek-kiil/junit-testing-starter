package ek.testing.movienight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

    // All films, the one that was suggested first comes first.
    List<Film> findAllByOrderByIdAsc();
}
