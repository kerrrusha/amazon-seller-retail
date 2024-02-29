package com.kerrrusha.amazonsellerretail.repository;

import com.kerrrusha.amazonsellerretail.domain.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
