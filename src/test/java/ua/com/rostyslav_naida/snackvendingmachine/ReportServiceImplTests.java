package ua.com.rostyslav_naida.snackvendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.rostyslav_naida.snackvendingmachine.dto.ProductDto;
import ua.com.rostyslav_naida.snackvendingmachine.repository.ReportRepo;
import ua.com.rostyslav_naida.snackvendingmachine.service.ReportService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReportServiceImplTests {
    ProductDto testDto = ProductDto.builder()
            .dateOfSale(LocalDate.parse("2016-08-16"))
            .productName("chocolate")
            .productPrice(10.5d)
            .build();

    @Autowired
    ReportService reportService;

    @Autowired
    ReportRepo reportRepo;


    @Test
    public void checkReportForMonth(){
        reportRepo.create(testDto);
        String expectation = "chocolate";
        String actual = reportService.reportForMonth(LocalDate.parse("2016-08-16")).get(0);
        assertTrue(actual.contains(expectation));
    }

}
