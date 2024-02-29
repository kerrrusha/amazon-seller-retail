package com.kerrrusha.amazonsellerretail.service;

import com.kerrrusha.amazonsellerretail.domain.SalesAndTrafficByDate;

import java.time.LocalDate;

public interface ReportService {
    SalesAndTrafficByDate findByDate(LocalDate date);
}
