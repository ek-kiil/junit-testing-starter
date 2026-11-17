package ek.testing.movienight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByStudentIdAndFilmId(Long studentId, Long filmId);

    int countByStudentId(Long studentId);

    int countByFilm(Film film);
}
