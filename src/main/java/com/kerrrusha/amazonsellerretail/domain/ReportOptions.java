package com.kerrrusha.amazonsellerretail.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReportOptions {
    @Id
    private String id;

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
