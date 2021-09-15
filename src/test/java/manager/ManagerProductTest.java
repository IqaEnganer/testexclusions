package manager;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

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
    private SmartPhone s = new SmartPhone(16, "Lich-Phone", 15000, "Japan");
    private SmartPhone s1 = new SmartPhone(15, "PutinPhone", 15000, "Russia");
    private SmartPhone s2 = new SmartPhone(17, "Apple", 15000, "USA");
    private SmartPhone s3 = new SmartPhone(15, "Link", 15000, "USA");
    private SmartPhone s4 = new SmartPhone(17, "Som-Phone", 15000, "Russia");

    @BeforeEach
    public void setup() {
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
        manager.add(s);
        manager.add(s1);
        manager.add(s2);
    }

    //Показать по автору и имени (книгу или телефон)
    @Test
    public void shouldSearchByName() {
        // Найдено по имени 1 Книга
        assertArrayEquals(new Product[]{b1}, manager.searchBy("Анжелика"));
    }

    @Test
    public void shouldSearchByManufacturer() {
        // Найдено по производителю 1 смартфон
        assertArrayEquals(new Product[]{s1}, manager.searchBy("Russia"));
    }

    @Test
    public void shouldSearchByNotExistingValue() {
        // Ничего не найдено
        assertArrayEquals(new Product[]{}, manager.searchBy("Имбирь"));
    }

    @Test
    public void shouldSearchByAuthor() {
        // Найдено по автору 2 книги
        assertArrayEquals(new Product[]{b, b1}, manager.searchBy("Аноним"));
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        // Найдено по названию 1 смартфон
        assertArrayEquals(new Product[]{s}, manager.searchBy("Lich-Phone"));
    }

    @Test
    public void shouldSearchByAuthorSeveralBook() {
        // Найдено по автору 4 Книги
        assertArrayEquals(new Product[]{b7, b8, b9, b10}, manager.searchBy("Author"));
    }
}
