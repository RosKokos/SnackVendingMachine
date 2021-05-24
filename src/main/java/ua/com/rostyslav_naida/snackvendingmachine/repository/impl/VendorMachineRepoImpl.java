package ua.com.rostyslav_naida.snackvendingmachine.repository.impl;

import org.springframework.stereotype.Repository;
import ua.com.rostyslav_naida.snackvendingmachine.model.VendingMachine;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ProductRepo;
import ua.com.rostyslav_naida.snackvendingmachine.repository.VendorMachineRepo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VendorMachineRepoImpl implements VendorMachineRepo {

    private static int id = 1;
    private final List<VendingMachine> vendingMachineList = new ArrayList<>(100);
    private final ProductRepo productRepo;

    VendorMachineRepoImpl(final ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public VendingMachine create(final VendingMachine machine) {
        machine.setId(id++);
        vendingMachineList.add(machine);
        return machine;
    }

    @Override
    public VendingMachine findById(final int id) {
        return vendingMachineList.get(id);
    }

    @Override
    public List<VendingMachine> findAll() {
        return vendingMachineList;
    }

    @Override
    public VendingMachine update(final VendingMachine machine) {

        if (machine == null || machine.getId() == 0) {
            throw new RuntimeException("Wrong ID");
        }
        vendingMachineList.set(machine.getId(), machine);
        return machine;
    }

    @Override
    public VendingMachine delete(final int id) {
        return vendingMachineList.remove(id);
    }

}
