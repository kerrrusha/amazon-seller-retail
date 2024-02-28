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
public class SalesAndTrafficByDate {
    @Id
    private String id;
}
