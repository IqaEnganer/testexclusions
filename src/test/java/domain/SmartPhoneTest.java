package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {
    SmartPhone smartPhone = new SmartPhone(1, "Panasonic", 1500, "Japan");

    @Test
    public void shouldSearchTrue() {
        boolean actual = smartPhone.matches("Japan");
        assertTrue(actual);
    }

    @Test
    public void shouldSearchFalse() {
        boolean actual = smartPhone.matches("Sochi");
        assertFalse(actual);
    }
}