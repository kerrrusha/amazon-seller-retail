package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class SalesAndTrafficByDate {

    private Date date;
    private SalesReport salesByDate;
    private TrafficReport trafficByDate;
}
