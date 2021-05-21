package ua.com.rostyslav_naida.snackvendingmachine.repository;

import ua.com.rostyslav_naida.snackvendingmachine.model.Product;

import java.util.List;

public interface ProductRepo {

    void create(Product product);

    Product findById(final int id);

    Product findByName(String name);

    List<Product> findAll();

    Product update(final Product product);

    Product delete(final int id);
}
