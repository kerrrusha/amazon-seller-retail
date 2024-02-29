package com.kerrrusha.amazonsellerretail.service.impl;

import com.kerrrusha.amazonsellerretail.domain.Report;
import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByAsin;
import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;
import com.kerrrusha.amazonsellerretail.repository.ReportRepository;
import com.kerrrusha.amazonsellerretail.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public List<SalesAndTrafficByDate> findByDateBetween(LocalDate dateFrom, LocalDate dateTo) {
        return getReport().getSalesAndTrafficByDate().stream()
                .filter(sale -> isDateBetween(sale.getDate(), dateFrom, dateTo))
                .toList();
    }

    @Override
    public SalesAndTrafficByAsin findByParentAsin(String parentAsin) {
        return getReport().getSalesAndTrafficByAsin().stream()
                .filter(sale -> sale.getParentAsin().equals(parentAsin))
                .findFirst()
                .orElse(null);
    }

    private boolean isDateBetween(LocalDate dateToCheck, LocalDate dateFrom, LocalDate dateTo) {
        return !dateToCheck.isBefore(dateFrom) && !dateToCheck.isAfter(dateTo);
    }

    private Report getReport() {
        return reportRepository.findAll().stream().findFirst().orElseThrow();
    }
}
