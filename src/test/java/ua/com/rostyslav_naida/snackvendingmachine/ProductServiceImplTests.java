package ua.com.rostyslav_naida.snackvendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.repository.impl.ProductRepoImpl;
import ua.com.rostyslav_naida.snackvendingmachine.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceImplTests {
    @Autowired
    ProductRepoImpl productRepo;
    @Autowired
    ProductService productService;



    @Test
    @Transactional
    public void checkFindAll() {
        int expectedSize = 3;
        List<Product> actual = productService.findAll();
        assertTrue(expectedSize<=actual.size(),String.format("At least %d products should be in products table", expectedSize));
    }
    @Test
    public void checkFindById(){
        String expectedName = "chocolate";
        Product actual = productService.findById(1);
        assertEquals(expectedName, actual.getName());
    }
}
