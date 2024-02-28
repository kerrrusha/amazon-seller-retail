package com.kerrrusha.amazonsellerretail.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReportSpecification {
    @Id
    private String id;

    private ReportType reportType;

    private ReportOptions reportOptions;

    private Date dataStartTime;

    private Date dataEndTime;

    private List<String> marketplaceIds;

    public enum ReportType {
        GET_SALES_AND_TRAFFIC_REPORT,
    }
}
