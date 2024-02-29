package com.kerrrusha.amazonsellerretail.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kerrrusha.amazonsellerretail.config.MongoTestContainerBase;
import com.kerrrusha.amazonsellerretail.domain.Report;
import com.kerrrusha.amazonsellerretail.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class ResourceJsonReportFetcherTest extends MongoTestContainerBase {

    private static final String reportResourceName = "test_report.json";

    @Autowired
    private ReportRepository reportRepository;

    @Mock
    private CacheManager cacheManager;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private ResourceJsonReportFetcher reportFetcher;

    @BeforeEach
    void beforeEach() {
        objectMapper.registerModule(new JavaTimeModule());
        reportFetcher = new ResourceJsonReportFetcher(reportRepository, objectMapper, cacheManager);
        reportFetcher.setReportResourceName(reportResourceName);
    }

    @Test
    void fetchReport() throws IOException {
        log.info("Report collection size: {}", reportRepository.findAll().size());
        assertTrue(reportRepository.findAll().isEmpty());

        //given
        when(cacheManager.getCacheNames()).thenReturn(emptyList());

        ClassPathResource resource = new ClassPathResource(reportResourceName);
        Report expectedReport = objectMapper.readValue(resource.getInputStream(), Report.class);

        //when
        reportFetcher.fetchReport();
        Report actualReport = reportRepository.findAll().get(0);
        expectedReport.setId(actualReport.getId());

        //then
        verify(cacheManager, times(1)).getCacheNames();
        assertEquals(expectedReport, actualReport);
    }
}
