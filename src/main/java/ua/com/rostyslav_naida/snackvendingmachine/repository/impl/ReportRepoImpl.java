package ua.com.rostyslav_naida.snackvendingmachine.repository.impl;

import org.springframework.stereotype.Repository;
import ua.com.rostyslav_naida.snackvendingmachine.dto.ProductDto;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ReportRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReportRepoImpl implements ReportRepo {
    private static int id = 1;
    private List<ProductDto> listOfBills = new ArrayList<>();

    @Override
    public void create(final ProductDto productDto) {
        productDto.setId(id++);
        listOfBills.add(productDto);
    }

    @Override
    public List<ProductDto> findAll() {
        return listOfBills;
    }

    @Override
    public ProductDto findByName(final String name) {
        return listOfBills.stream()
                .filter(p -> p.getProductName().equals(name))
                .findFirst()
                .get();
    }
}
