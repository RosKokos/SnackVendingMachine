package ua.com.rostyslav_naida.snackvendingmachine.repository.impl;

import org.springframework.stereotype.Repository;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {
 private  List<Product> productList = new ArrayList<>(100);
    private static int id = 1;
    @Override
    public void create(Product product){
            product.setId(id++);
            productList.add(product);
    }

    @Override
    public Product findById(final int id) {
        return productList.get(id -1);
    }

    @Override
    public Product findByName(String name){
        return productList.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .get();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product update(final Product product) {
        if(product==null||product.getId()==0){
            throw new RuntimeException("Missed Id");
        }
        productList.set(product.getId() - 1,product);
        return product;
    }

    @Override
    public Product delete(final int id) {
        return productList.remove(id);
    }
}
