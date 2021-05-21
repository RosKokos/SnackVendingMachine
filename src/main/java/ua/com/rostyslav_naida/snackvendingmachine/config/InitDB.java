package ua.com.rostyslav_naida.snackvendingmachine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.model.VendingMachine;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ProductRepo;
import ua.com.rostyslav_naida.snackvendingmachine.repository.VendorMachineRepo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDB {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    VendorMachineRepo vendorMachineRepo;

    @PostConstruct
    private void init() {
        final Product product = Product.builder()
                .name("chocolate")
                .price(12.9d)
                .stock(2)
                .build();
        productRepo.create(product);
        final Product product1 = Product.builder()
                .name("cookies")
                .price(10.5d)
                .stock(12)
                .selectionNumber(1)
                .build();
        productRepo.create(product1);
        final Product product2 = Product.builder()
                .name("chips")
                .price(5.9d)
                .stock(12)
                .selectionNumber(2)
                .build();
        productRepo.create(product2);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);

        VendingMachine poxMachine = VendingMachine.builder()
                .name("pox")
                .productList(products)
                .build();
        vendorMachineRepo.create(poxMachine);
    }
}
