package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }


    //    public boolean productSearch(String search) {
//        if (super.productSearch(search)) {
//            return true;
//        }
//        if (getAuthor().contains(search)) {
//            return true;
//        }
//        return false;
//    }
    @Override
    public boolean matches(String search) {
        return super.matches(search) || getAuthor().contains(search);
    }

}
