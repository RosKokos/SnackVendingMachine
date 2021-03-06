package ua.com.rostyslav_naida.snackvendingmachine.repository;

import ua.com.rostyslav_naida.snackvendingmachine.dto.ProductDto;

import java.util.List;

public interface ReportRepo {

    void create(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findByName(String name);


}
