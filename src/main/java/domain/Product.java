package domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        }
        return false;
    }

}

