package ua.com.rostyslav_naida.snackvendingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.rostyslav_naida.snackvendingmachine.model.Product;
import ua.com.rostyslav_naida.snackvendingmachine.service.ProductService;
import ua.com.rostyslav_naida.snackvendingmachine.service.VendingMachineService;

@Controller
public class ProductController {

    final ProductService productService;
    final VendingMachineService vendingMachineService;

    public ProductController(final ProductService productService, final VendingMachineService vendingMachineService) {
        this.productService = productService;
        this.vendingMachineService = vendingMachineService;
    }
    @GetMapping("api/service/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "addItem";
    }
    @PostMapping("api/service/create")
    public String create(@Validated @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()){
            return "addItem";
        }
        vendingMachineService.addCategory(product);
        return "redirect:/api/products";
    }

    @GetMapping("api/service/{id}/update")
    public String updateItem(@PathVariable long id, Model model){
        model.addAttribute("products", productService.findById((int)id));
        return "changeItem";
    }
    @PostMapping("api/service/update")
    public String updateItem(@Validated @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()){
            return "changeItem";
        }
        vendingMachineService.addItem(product.getName(), product.getStock());
        return "redirect:/api/products";
    }
}
