package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Sale {

    private double amount;
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD,
    }
}
