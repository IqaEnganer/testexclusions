package manager;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import java.util.PrimitiveIterator;
import java.util.prefs.PreferencesFactory;

import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {
    private ProductRepository repository = new ProductRepository();
    private ManagerProduct manager = new ManagerProduct(repository);
    private Book book1 = new Book();
    private Book b = new Book(1, "Гибкое мышление", 800, "Аноним");
    private Book b1 = new Book(2, "Анжелика", 700, "Аноним");
    private Book b2 = new Book(3, "Гарри Поттер", 10000, "Шикомару");
    private Book b3 = new Book(4, "Дракон", 500, "Давид Дзен");
    private Book b4 = new Book(5, "Гори в аду", 700, "Лиза Нум");
    private Book b5 = new Book(6, "Адреналин", 600, "Rush");
    private Book b6 = new Book(7, "Гибкий утенок", 200, "Аист");
    private Book b7 = new Book(8, "Карие руки", 400, "Author");
    private Book b8 = new Book(9, "Ногти во мгле", 500, "Author");
    private Book b9 = new Book(10, "Прах Учих", 100, "Author");
    private Book b10 = new Book(11, "Карандаш между ног", 1200, "Author");
    private Book b11 = new Book(12, "Широкое познание", 520, "Author");
    private Book b12 = new Book(13, "Взгляд в никуда", 160, "Author");
    private Book b13 = new Book(14, "Горе в поезде", 450, "Author");
    private SmartPhone s = new SmartPhone(16, "Lich-Phone", 15000, "Japan");
    private SmartPhone s1 = new SmartPhone(15, "Som-Phone", 15000, "Russia");
    private SmartPhone s2 = new SmartPhone(17, "Som-Phone", 15000, "Russia");

    @Test
    public void shouldFixProduct(){
        ManagerProduct product = new ManagerProduct(repository);
        product.setNumberDisplayedFilms(1);
        product.add(b2);
        product.add(b5);
        assertArrayEquals(new Product[]{b5},product.findAllFixReverse());
    }

    @Test
    public void showSaveAndAllDeleteProduct() {
        manager.add(b);
        manager.add(b1);
        manager.add(b2);
        manager.add(b4);
        manager.remove(5);
        assertArrayEquals(new Product[]{b2, b1, b}, manager.findAllFixReverse());
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.add(s);
        manager.add(s1);
        assertArrayEquals(new Product[]{b, b1, b2, b3, b4, b5, s, s1}, manager.findAll());
        manager.removeALl();
        assertArrayEquals(new Product[0], manager.findAll());
        assertEquals(10, manager.getNumberDisplayedFilms());
        manager.setNumberDisplayedFilms(5);
        assertEquals(5, manager.getNumberDisplayedFilms());


    }


    @Test
    public void shouldSearchByNameAndSearchByAuthor() {
        manager.add(b);
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(b4);
        manager.add(b5);
        manager.add(b6);
        manager.add(b7);
        manager.add(b8);
        manager.add(b9);
        manager.add(b10);
        manager.add(b11);
        manager.add(s);
        manager.add(s1);
        manager.add(s2);
        assertArrayEquals(new Product[]{b1}, manager.searchBy("Анжелика"));
        assertArrayEquals(new Product[]{s1,s2}, manager.searchBy("Russia"));
        assertArrayEquals(new Product[]{}, manager.searchBy("Имбирь"));
        assertArrayEquals(new Product[]{b, b1}, manager.searchBy("Аноним"));
        assertArrayEquals(new Product[]{s}, manager.searchBy("Lich-Phone"));
        assertArrayEquals(new Product[]{b7,b8,b9,b10,b11}, manager.searchBy("Author"));

    }
    @Test
    public void shouldSmartNonExistent(){
        manager.add(s);
        manager.add(s1);
        assertArrayEquals(new Product[]{},manager.searchBy("Moza"));
    }

}