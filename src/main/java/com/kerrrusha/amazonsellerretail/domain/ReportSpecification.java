package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class ReportSpecification {

    private ReportType reportType;

    private ReportOptions reportOptions;

    private Date dataStartTime;

    private Date dataEndTime;

    private List<String> marketplaceIds;

    public enum ReportType {
        GET_SALES_AND_TRAFFIC_REPORT,
    }
}
