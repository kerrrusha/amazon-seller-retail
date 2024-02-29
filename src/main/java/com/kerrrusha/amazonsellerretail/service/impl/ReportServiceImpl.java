package com.kerrrusha.amazonsellerretail.service.impl;

import com.kerrrusha.amazonsellerretail.domain.Report;
import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByAsin;
import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;
import com.kerrrusha.amazonsellerretail.repository.ReportRepository;
import com.kerrrusha.amazonsellerretail.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    @Cacheable("findByDateResults")
    public SalesAndTrafficByDate findByDate(LocalDate date) {
        log.debug("Called findByDate method (no cache yet)");
        return getReport().getSalesAndTrafficByDate().stream()
                .filter(sale -> sale.getDate().equals(date))
                .findFirst()
                .orElse(null);
    }

    @Override
    @Cacheable("findByDateBetweenResults")
    public List<SalesAndTrafficByDate> findByDateBetween(LocalDate dateFrom, LocalDate dateTo) {
        return getReport().getSalesAndTrafficByDate().stream()
                .filter(sale -> isDateBetween(sale.getDate(), dateFrom, dateTo))
                .toList();
    }

    @Override
    @Cacheable("findByParentAsinResults")
    public List<SalesAndTrafficByAsin> findByParentAsin(List<String> parentAsinList) {
        return getReport().getSalesAndTrafficByAsin().stream()
                .filter(sale -> parentAsinList.contains(sale.getParentAsin()))
                .toList();
    }

    @Override
    @Cacheable("findAllByDateResults")
    public List<SalesAndTrafficByDate> findAllByDate() {
        return getReport().getSalesAndTrafficByDate();
    }

    @Override
    @Cacheable("findAllByAsinResults")
    public List<SalesAndTrafficByAsin> findAllByAsin() {
        return getReport().getSalesAndTrafficByAsin();
    }

    private boolean isDateBetween(LocalDate dateToCheck, LocalDate dateFrom, LocalDate dateTo) {
        return !dateToCheck.isBefore(dateFrom) && !dateToCheck.isAfter(dateTo);
    }

    private Report getReport() {
        return reportRepository.findAll().stream().findFirst().orElseThrow();
    }
}
