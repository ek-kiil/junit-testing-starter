package ek.testing.movienight;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

// Task 3: a unit test with mocks
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class VoteServiceMockTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    FilmRepository filmRepository;

    @Mock
    VoteRepository voteRepository;

    @InjectMocks
    VoteService voteService;

    @Test
    void aVoteIsSaved() {
        Student sara = new Student("Sara");
        Film alien = new Film("Alien");

        voteService.vote(1L, 2L);

        verify(voteRepository).save(any(Vote.class));
    }

    @Test
    void aVoteFromAnUnknownStudentIsRefused() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> voteService.vote(1L, 2L));
    }
}
