package ek.testing.password;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

// Task 2: testing exceptions
class PasswordTest {

    @Test
    void aLongPasswordWithoutSpacesIsAccepted() {
        assertDoesNotThrow(() -> new Password("sommerhus2026"));
    }
}
