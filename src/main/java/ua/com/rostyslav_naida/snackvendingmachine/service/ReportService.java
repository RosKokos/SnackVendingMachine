package ua.com.rostyslav_naida.snackvendingmachine.service;

import ua.com.rostyslav_naida.snackvendingmachine.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<String> reportForMonth(final LocalDate date);

    List<String> sortedReportFromDate(final String date);
}
