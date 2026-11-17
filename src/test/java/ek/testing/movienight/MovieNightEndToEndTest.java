package ek.testing.movienight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

// Task 6, step 2: through the whole application
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MovieNightEndToEndTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    VoteService voteService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FilmRepository filmRepository;

    Student sara;
    Student jonas;
    Film alien;
    Film heat;

    @BeforeEach
    void setUp() {
        sara = studentRepository.save(new Student("Sara"));
        jonas = studentRepository.save(new Student("Jonas"));
        alien = filmRepository.save(new Film("Alien"));
        heat = filmRepository.save(new Film("Heat"));
    }

    @Test
    void aVoteSentToTheApiIsCounted() throws Exception {
        mockMvc.perform(post("/films/{filmId}/votes", alien.getId())
                        .param("studentId", sara.getId().toString()))
                .andExpect(status().isNoContent());

        assertEquals(1, voteService.votesFor(alien.getId()));
    }
}
