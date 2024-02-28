package com.kerrrusha.amazonsellerretail.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SalesReport {

    private Sale orderedProductSales;
    private Sale orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private Sale averageSalesPerOrderItem;
    private Sale averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private Sale averageSellingPrice;
    private Sale averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private Sale claimsAmount;
    private Sale shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;
}
