package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SalesAndTrafficByAsin {

    private String parentAsin;
    private SalesReport salesByAsin;
    private TrafficReport trafficByAsin;
}
