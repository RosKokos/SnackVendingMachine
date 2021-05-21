package ua.com.rostyslav_naida.snackvendingmachine.service;

import ua.com.rostyslav_naida.snackvendingmachine.model.Product;

import java.util.List;

public interface VendingMachineService {

    List<Product> list();

    String addCategory(final Product category);

    String addItem(final String name, final int stock);

    String purchase(final int id);

}
