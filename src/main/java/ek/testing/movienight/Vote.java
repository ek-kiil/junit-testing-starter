package ek.testing.movienight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Film film;

    protected Vote() {
    }

    public Vote(Student student, Film film) {
        this.student = student;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Film getFilm() {
        return film;
    }
}
