package ua.com.rostyslav_naida.snackvendingmachine.service.impl;

import org.springframework.stereotype.Service;
import ua.com.rostyslav_naida.snackvendingmachine.dto.ProductDto;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ReportRepo;
import ua.com.rostyslav_naida.snackvendingmachine.service.ReportService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    final ReportRepo reportRepo;

    public ReportServiceImpl(final ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public List<String> reportForMonth(final LocalDate date) {

        return getFoolString(grouping(date));
    }

    @Override
    public List<String> sortedReportFromDate(final String date) {
        LocalDate localDate = LocalDate.parse(date);
        Map<String, Long> groupByDateAndName = reportRepo.findAll().stream()
                .filter(bill -> bill.getDateOfSale().isAfter(localDate))
                .collect(Collectors.groupingBy(ProductDto::getProductName, Collectors.counting()));
        return getFoolString(groupByDateAndName);
    }


    private Map<String, Long> grouping(final LocalDate date) {

        Map<String, Long> groupByName = reportRepo.findAll().stream()
                .filter(bill -> bill.getDateOfSale().getMonth().equals(date.getMonth()))
                .collect(Collectors.groupingBy(ProductDto::getProductName, Collectors.counting()));
        return groupByName;
    }

    private List<String> getFoolString(final Map<String, Long> groupByName) {
        List<String> report = new ArrayList<>();
        double total = 0;
        for (Map.Entry<String, Long> item : groupByName.entrySet()) {

            double prise = reportRepo.findByName(item.getKey()).getProductPrice();
            report.add(item.getKey() + " " + prise + " " + item.getValue());
            total += prise * item.getValue();
        }
        report.add(String.format(">Total %,.2f", total));
        return report;
    }
}
