package com.kerrrusha.amazonsellerretail.controller;

import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;
import com.kerrrusha.amazonsellerretail.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private final ReportService reportService;

    @GetMapping("/by-date")
    public SalesAndTrafficByDate findByDate(
            @RequestParam("date") @DateTimeFormat(pattern= DEFAULT_DATE_FORMAT) LocalDate date) {
        return reportService.findByDate(date);
    }

    @GetMapping("/by-date-between")
    public ResponseEntity<List<SalesAndTrafficByDate>> findByDateBetween(
            @RequestParam("dateFrom") @DateTimeFormat(pattern=DEFAULT_DATE_FORMAT) LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern=DEFAULT_DATE_FORMAT) LocalDate dateTo) {
        if (!dateTo.isAfter(dateFrom)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(reportService.findByDateBetween(dateFrom, dateTo));
    }
}
