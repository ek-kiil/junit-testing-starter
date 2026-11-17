package ek.testing.movienight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// Task 5: the winner
@SpringBootTest
@Transactional
class VoteServiceWinnerTest {

    @Autowired
    VoteService voteService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FilmRepository filmRepository;

}
