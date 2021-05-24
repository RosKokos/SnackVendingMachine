package ua.com.rostyslav_naida.snackvendingmachine.service;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    List<String> reportByMonth(final LocalDate date);

    List<String> sortedReportFromDate(final String date);
}
