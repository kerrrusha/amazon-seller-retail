package com.kerrrusha.amazonsellerretail.repository;

import com.kerrrusha.amazonsellerretail.domain.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@Testcontainers
@ExtendWith(SpringExtension.class)
public class UserRepositoryIntegrationTest {

    @Container
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void setUp() {
        mongoDBContainer.start();
    }

    @Test
    void testSaveUser() {
        // Given
        User user = new User();

        user.setEmail("test@test.com");
        user.setPassword("test");

        // When
        userRepository.save(user);

        // Then
        User savedUser = userRepository.findById(user.getId()).orElseThrow();

        assertNotNull(savedUser);
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @AfterAll
    static void tearDown() {
        mongoDBContainer.stop();
    }
}
