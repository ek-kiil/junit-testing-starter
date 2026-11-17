package ek.testing.movienight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// Task 4: an integration test
@SpringBootTest
@Transactional
class VoteServiceTest {

    @Autowired
    VoteService voteService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FilmRepository filmRepository;

    Student sara;
    Film alien;

    @BeforeEach
    void setUp() {
        // arrange

    }

    @Test
    void aVoteCountsForTheFilm() {
        // act
        voteService.vote(sara.getId(), alien.getId());

        // assert
        assertEquals(1, voteService.votesFor(alien.getId()));
    }
}
