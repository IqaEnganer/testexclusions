package domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Book extends Product {
    String name;
    String author;



    public Book(){
    }
    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}
