package ua.com.rostyslav_naida.snackvendingmachine.service;

import ua.com.rostyslav_naida.snackvendingmachine.model.Product;

import java.util.List;
import java.util.Properties;

public interface ProductService {

    List<Product> findAll();
    Product findById(int id);


}
