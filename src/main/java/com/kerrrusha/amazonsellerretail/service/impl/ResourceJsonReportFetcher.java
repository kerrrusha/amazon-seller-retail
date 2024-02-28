package com.kerrrusha.amazonsellerretail.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kerrrusha.amazonsellerretail.domain.Report;
import com.kerrrusha.amazonsellerretail.service.ReportFetcher;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceJsonReportFetcher implements ReportFetcher {

    private final MongoTemplate mongoTemplate;
    private final ObjectMapper objectMapper;

    @Value("${stats.source.resource}")
    private String reportResourceName;

    @Override
    @SneakyThrows
    @Scheduled(fixedRateString = "${stats.refresh-each.ms}")
    public void fetchReport() {
        ClassPathResource resource = new ClassPathResource(reportResourceName);
        Report testReport = objectMapper.readValue(resource.getInputStream(), Report.class);

        truncateReportCollection();
        mongoTemplate.save(testReport);

        log.info("Report fetched successfully.");
    }

    private void truncateReportCollection() {
        mongoTemplate.dropCollection(Report.class);
    }
}
