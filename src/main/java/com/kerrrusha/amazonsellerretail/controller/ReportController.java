package com.kerrrusha.amazonsellerretail.controller;

import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;
import com.kerrrusha.amazonsellerretail.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/by-date")
    public SalesAndTrafficByDate findByDate(
            @RequestParam("date")
            @DateTimeFormat(pattern="yyyy-MM-dd")
            LocalDate date) {
        return reportService.findByDate(date);
    }
}
