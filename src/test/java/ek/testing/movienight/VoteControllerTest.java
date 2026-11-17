package ek.testing.movienight;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

// Task 6: a controller test
@WebMvcTest(VoteController.class)
class VoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    VoteService voteService;

    @Test
    void aVoteThatIsTakenAnswers204() throws Exception {
        mockMvc.perform(post("/films/2/votes").param("studentId", "1"))
                .andExpect(status().isNoContent());

        verify(voteService).vote(1L, 2L);
    }

    @Test
    void aRefusedVoteAnswers400() throws Exception {
        doThrow(new IllegalArgumentException("You have already voted for this film"))
                .when(voteService).vote(1L, 2L);

        mockMvc.perform(post("/films/2/votes").param("studentId", "1"))
                .andExpect(status().isBadRequest());
    }
}
