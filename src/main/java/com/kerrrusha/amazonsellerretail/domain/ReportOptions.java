package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ReportOptions {

    private DateGranularity dateGranularity;
    private AsinGranularity asinGranularity;

    public enum DateGranularity {
        DAY,
        WEEK,
        MONTH,
    }

    public enum AsinGranularity {
        PARENT,
        CHILD,
        SKU,
    }
}
