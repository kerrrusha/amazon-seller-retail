package com.kerrrusha.amazonsellerretail.service.impl;

import com.kerrrusha.amazonsellerretail.domain.Report;
import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;
import com.kerrrusha.amazonsellerretail.repository.ReportRepository;
import com.kerrrusha.amazonsellerretail.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public SalesAndTrafficByDate findByDate(LocalDate date) {
        return getReport().getSalesAndTrafficByDate().stream()
                .filter(sale -> sale.getDate().equals(date))
                .findFirst()
                .orElse(null);
    }

    private Report getReport() {
        return reportRepository.findAll().stream().findFirst().orElseThrow();
    }
}
