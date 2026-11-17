package ek.testing.movienight;

import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final StudentRepository studentRepository;
    private final FilmRepository filmRepository;
    private final VoteRepository voteRepository;

    public VoteService(StudentRepository studentRepository,
                       FilmRepository filmRepository,
                       VoteRepository voteRepository) {
        this.studentRepository = studentRepository;
        this.filmRepository = filmRepository;
        this.voteRepository = voteRepository;
    }

    public void vote(Long studentId, Long filmId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown student"));
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown film"));

        voteRepository.save(new Vote(student, film));
    }

    public int votesFor(Long filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalArgumentException("Unknown film"));
        return voteRepository.countByFilm(film);
    }

    public Film winner() {
        // not written yet (task 5)
        return null;
    }
}
