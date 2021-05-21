package ua.com.rostyslav_naida.snackvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;

import java.util.List;
import java.util.Properties;

public interface ProductRepo {
    void create(Product product);

    Product findById(final int id);

    Product findByName(String name);

    List<Product> findAll();

    Product update(final Product product);

    Product delete(final int id);
}
