package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Report {

    @Id
    private String id;

    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
