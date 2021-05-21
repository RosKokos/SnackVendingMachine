package ua.com.rostyslav_naida.snackvendingmachine.repository;

import ua.com.rostyslav_naida.snackvendingmachine.model.VendingMachine;

import java.util.List;

public interface VendorMachineRepo {

    VendingMachine create(final VendingMachine product);

    VendingMachine findById(final int id);

    List<VendingMachine> findAll();

    VendingMachine update(final VendingMachine product);

    VendingMachine delete(final int id);
}
