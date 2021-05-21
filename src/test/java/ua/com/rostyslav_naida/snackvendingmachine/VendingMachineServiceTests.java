package ua.com.rostyslav_naida.snackvendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.repository.impl.ProductRepoImpl;
import ua.com.rostyslav_naida.snackvendingmachine.service.VendingMachineService;
import ua.com.rostyslav_naida.snackvendingmachine.service.impl.VendingMachineServiceImpl;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VendingMachineServiceTests {

    final Product product = Product.builder()
            .name("rise")
            .price(12.9d)
            .stock(2)
            .selectionNumber(5)
            .build();
    final Product product2 = Product.builder()
            .name("pizza")
            .price(12.9d)
            .stock(2)
            .selectionNumber(5)
            .build();

    @Autowired
    ProductRepoImpl productRepoImpl;

    @Autowired
    VendingMachineService vendingMachineService;

    @Autowired
    VendingMachineServiceImpl vendingMachineServiceImpl;

    @Test
    @Transactional
    public void checkAddCategory() {
        String expectation = String.format("%s %f %d ", product.getName(), product.getPrice(), product.getSelectionNumber());
        String actual = vendingMachineService.addCategory(product);
        assertEquals(expectation, actual);
    }

    @Test
    @Transactional
    public void checkAddItem(){
        String expectation = String.format("%s %f %d", product2.getName(), product2.getPrice(), product2.getStock() + 1);
        vendingMachineService.addCategory(product2);
        String actual = vendingMachineService.addItem("pizza", 1);
        assertEquals(expectation, actual);
    }

    @Test
    @Transactional
    public void checkPurchase(){
        int expectation = 11;
        vendingMachineServiceImpl.purchase(3);
        int actual = productRepoImpl.findById(3).getStock();
        assertEquals(expectation, actual);
    }
    @Test
    @Transactional
    public void checkList(){
        int expectation = 4;
        int actual = vendingMachineService.list().size();
        assertEquals(expectation, actual);
    }
}
