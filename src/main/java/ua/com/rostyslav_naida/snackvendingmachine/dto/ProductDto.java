package ua.com.rostyslav_naida.snackvendingmachine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductDto {

    private static int count = 0;

    private int id;

    private LocalDate dateOfSale;

    private String name;

    private double price;

}
