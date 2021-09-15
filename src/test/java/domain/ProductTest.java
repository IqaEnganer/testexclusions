package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(1, "Product", 1500);

    @Test
    public void shouldSearchMatchTrue() {
        boolean actual = product.matches("Product");
        assertTrue(actual);
    }

    @Test
    public void shouldSearchMatchFalse() {
        boolean actual = product.matches("O");
        assertFalse(actual);
    }

}