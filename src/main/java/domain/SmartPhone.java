package domain;

import lombok.Data;

import java.util.Objects;

@Data
public class SmartPhone extends Product {
    private String manufacturer;

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
