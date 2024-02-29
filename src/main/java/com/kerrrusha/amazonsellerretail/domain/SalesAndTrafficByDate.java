package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class SalesAndTrafficByDate {

    private LocalDate date;
    private SalesReport salesByDate;
    private TrafficReport trafficByDate;
}
