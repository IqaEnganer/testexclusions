package repository;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book = new Book(1,"Лень",20,"Fih");
    private Book b = new Book(1, "Гибкое мышление", 800,  "Author");
    private Book b1 = new Book(2, "Анжелика", 700,  "Author");
    private Book b2 = new Book(3, "Гарри Поттер", 10000,  "Author");
    private Book b3 = new Book(4, "Дракон", 500,  "Author");
    private Book b4 = new Book(5, "Гори в аду", 700,  "Author");
    private Book b5 = new Book(6, "Адреналин", 600,  "Author");
    private Book b6 = new Book(7, "Гибкий утенок", 200,  "Author");
    private Book b7 = new Book(8, "Карие руки", 400,  "Author");
    private Book b8 = new Book(9, "Ногти во мгле", 500,  "Author");
    private Book b9 = new Book(10, "Прах Учих", 100,  "Author");
    private Book b10 = new Book(11, "Карандаш между ног", 1200,  "Author");
    private Book b11 = new Book(12, "Широкое познание", 520,  "Author");
    private Book b12 = new Book(13, "Взгляд в никуда", 160,  "Author");
    private Book b13 = new Book(14, "Горе в поезде", 450,  "Author");
    private SmartPhone s = new SmartPhone(16, "Lich-Phone", 15000,  "Japan");
    private SmartPhone s1 = new SmartPhone(15, "Som-Phone", 15000, "Japan");


    @Test
    public void showSaveBooks() {
        repository.save(b);
        repository.save(b2);
        repository.save(b3);
        repository.save(book);


        Product[] expected = new Product[]{b, b2, b3,book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showSaveBooksReverse() {
        repository.save(b);
        repository.save(b2);
        repository.save(b3);
        repository.save(s);
        repository.removeById(3);

        Product[] expected = new Product[]{b,b3,s};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showFindById() {
        repository.save(b1);
        Product[] expected = new Product[]{b1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void getSetProduct(){
        book.setName("Amoterasu");
        assertEquals("Amoterasu",book.getName());
    }

}