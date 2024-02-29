package com.kerrrusha.amazonsellerretail.service;

import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    SalesAndTrafficByDate findByDate(LocalDate date);

    List<SalesAndTrafficByDate> findByDateBetween(LocalDate dateFrom, LocalDate dateTo);
}
