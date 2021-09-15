package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)

public class SmartPhone extends Product {
    private String manufacturer;

    public SmartPhone() {
    }

    public SmartPhone(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public SmartPhone(int id, String name, int price) {
        super(id, name, price);
    }


    //    public boolean productSearch(String search) {
//        if (super.productSearch(search)){
//            return true;
//        }
//        if (getManufacturer().contains(search)) {
//            return true;
//        }
//        return false;
//    }
    @Override
    public boolean matches(String search) {
        return super.matches(search) || getManufacturer().contains(search);
    }
}
