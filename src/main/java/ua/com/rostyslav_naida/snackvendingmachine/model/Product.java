package ua.com.rostyslav_naida.snackvendingmachine.model;

import lombok.*;

import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    private int id;

    private String name;

    private double price;

    private int selectionNumber;

    private int stock;

    private int machineId;

    public Product(String name, double price, int selectionNumber) {
        this.name = name;
        this.price = price;
        this.selectionNumber = selectionNumber;
        this.stock = 0;
    }

    public Product(String name, double price, int selectionNumber, int stock) {
        this.name = name;
        this.price = price;
        this.selectionNumber = selectionNumber;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product='" + name + '\'' +
                ", price=" + price +
                ", selectionNumber=" + selectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && selectionNumber == product.selectionNumber && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, selectionNumber);
    }
}
