package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveMethodFromSuper(){
        Book book = new Book(1,"b",2000,"b");
        Book book1 = new Book(1,"b",2000,"b");
        assertEquals("b",book.getName());
        assertEquals("b", book1.getName());
        assertEquals(2000, book.getPrice());
        assertEquals(book,book1);

    }

}