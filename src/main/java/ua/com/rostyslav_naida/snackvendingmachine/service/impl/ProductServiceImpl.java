package ua.com.rostyslav_naida.snackvendingmachine.service.impl;

import org.springframework.stereotype.Service;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ProductRepo;
import ua.com.rostyslav_naida.snackvendingmachine.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(final int id) {
        return productRepo.findById(id);
    }

}
