package com.kerrrusha.amazonsellerretail.repository;

import com.kerrrusha.amazonsellerretail.config.MongoTestContainerBase;
import com.kerrrusha.amazonsellerretail.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryIntegrationTest extends MongoTestContainerBase {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        assertTrue(userRepository.findAll().isEmpty());

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
}
