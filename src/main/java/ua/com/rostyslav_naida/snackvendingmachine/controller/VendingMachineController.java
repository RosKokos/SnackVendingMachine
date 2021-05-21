package ua.com.rostyslav_naida.snackvendingmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.rostyslav_naida.snackvendingmachine.model.DateContainer;
import ua.com.rostyslav_naida.snackvendingmachine.service.ProductService;
import ua.com.rostyslav_naida.snackvendingmachine.service.ReportService;
import ua.com.rostyslav_naida.snackvendingmachine.service.VendingMachineService;

import java.time.LocalDate;

@Controller
@RequestMapping("/api")
public class VendingMachineController {

    final ProductService productService;
    final ReportService reportService;
    final VendingMachineService vendingMachineService;

    public VendingMachineController(final ProductService productService, final ReportService reportService, final VendingMachineService vendingMachineService) {
        this.productService = productService;
        this.reportService = reportService;
        this.vendingMachineService = vendingMachineService;
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @GetMapping("/products/{id}/purchase")
    public String purchase(@PathVariable long id, Model model) {

        model.addAttribute("check", vendingMachineService.purchase((int) id));

        return "check";
    }

    @GetMapping("/service")
    public String machineService(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("date", new DateContainer());
        return "machine_service";
    }

    @GetMapping("/service/report")
    public String monthReport(Model model) {
        model.addAttribute("report", reportService.reportForMonth(LocalDate.now()));
        return "report";
    }

    @GetMapping("/service/report/period")
    public String reportForCertainPeriod(@Validated @ModelAttribute("date") DateContainer date, Model model, BindingResult result) {
        model.addAttribute("report", reportService.sortedReportFromDate(date.getDates()));
        return "report";
    }
}
