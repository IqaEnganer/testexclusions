package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(1, "1", 150, "Хакимару");

    @Test
    public void shouldSearchMatchesByCoincidenceTrue() {
        boolean actual = book.matches("Хакимару");
        assertTrue(actual);
    }

    @Test
    public void shouldSearchMatchesByCoincidenceFalse() {
        boolean actual = book.matches("Онегин");
        assertFalse(actual);
    }

}