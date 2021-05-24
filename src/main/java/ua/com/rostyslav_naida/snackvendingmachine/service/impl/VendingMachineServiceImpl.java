package ua.com.rostyslav_naida.snackvendingmachine.service.impl;

import org.springframework.stereotype.Service;
import ua.com.rostyslav_naida.snackvendingmachine.dto.ProductDto;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ProductRepo;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ReportRepo;
import ua.com.rostyslav_naida.snackvendingmachine.service.VendingMachineService;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    final ProductRepo productRepo;
    final ReportRepo reportRepo;

    VendingMachineServiceImpl(ProductRepo productRepo, ReportRepo reportRepo) {
        this.productRepo = productRepo;
        this.reportRepo = reportRepo;
    }

    @Override
    public String addCategory(final Product category) {

        if (productRepo.findAll().contains(category)) {
            throw new RuntimeException("Category already exist!");
        }
        productRepo.create(category);

        return String.format("%s %f %d ",
                category.getName(),
                category.getPrice(),
                category.getSelectionNumber());
    }

    @Override
    public String addItem(final String name, final int stock) {
        Product addStock = productRepo.findByName(name);
        addStock.setStock(addStock.getStock() + stock);
        productRepo.update(addStock);
        return String.format("%s %f %d",
                addStock.getName(),
                addStock.getPrice(),
                addStock.getStock());
    }

    @Override
    public String purchase(final int id) {
        Product product = productRepo.findById(id);
        if (product.getStock() == 0) {
            throw new RuntimeException("Purchase forbidden, stock = 0");
        }
        product.setStock(product.getStock() - 1);
        productRepo.update(product);
        return transfer(product);
    }

    @Override
    public List<Product> list() {
        return productRepo.findAll();
    }

    private String transfer(Product product) {
        ProductDto productDto = ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .dateOfSale(LocalDate.now())
                .build();
        reportRepo.create(productDto);

        return String.format("%s %n %s %,.2f",
                productDto.getDateOfSale().toString(),
                productDto.getName(),
                productDto.getPrice());
    }
}
